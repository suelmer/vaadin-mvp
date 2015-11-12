package com.jrtech.tools.admins.views;

import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.domain.Country;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.ExpandEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdministrativeViewImpl extends CustomComponent implements Tree.ExpandListener, AdministrativeView {

	private static final long serialVersionUID = 5685759058955122548L;
	public static final String NAME = "adminView";
	
	private Tree tree;
	private HorizontalSplitPanel panel;

	@Override
    @Transactional
	public void enter(ViewChangeEvent event) {
		panel = new HorizontalSplitPanel();
		panel.setSplitPosition(25, Unit.PERCENTAGE);
		setCompositionRoot(panel);

        tree = new Tree();
        tree.addContainerProperty("name", String.class, "");
        tree.setItemCaptionPropertyId("name");
        tree.addExpandListener(this);
        panel.setFirstComponent(tree);


        Panel map = new Panel();
        panel.setSecondComponent(map);

		
		for (AdministrativeViewListener listener : listeners){
			listener.enterView();
		}
		
	}

	@Override
	public void nodeExpand(ExpandEvent event) {
		for (AdministrativeViewListener listener : listeners) {
            listener.nodeExpand((String)event.getItemId());
        }
	}

	@Override
	public void initView(Country root) {
		tree.addItem(root.getCode());
		tree.getItem(root.getCode()).getItemProperty("name").setValue(root.getName());
        tree.setChildrenAllowed(root.getCode(), !root.getChildren().isEmpty());

        if (!root.getChildren().isEmpty()) {
            fillChildren(root.getCode(), root.getChildren());
        }

		tree.expandItem(root.getCode());
	}

	@Override
	public void expandNode(Administrative parent) {
        if (null != parent)
		    fillChildren(parent.getCode(), parent.getChildren());
	}

    private void fillChildren(String parentCode, List<Administrative> children) {
        for (Administrative admin : children) {
            tree.addItem(admin.getCode());
            tree.getItem(admin.getCode()).getItemProperty("name").setValue(admin.getName());
            tree.setParent(admin.getCode(), parentCode);
            tree.setChildrenAllowed(admin.getCode(), !admin.getChildren().isEmpty());
        }
    }

	private List<AdministrativeViewListener> listeners = new ArrayList<AdministrativeViewListener>();
    @Override
    public void addListener(AdministrativeViewListener listener) {
        listeners.add(listener);
    }
}
