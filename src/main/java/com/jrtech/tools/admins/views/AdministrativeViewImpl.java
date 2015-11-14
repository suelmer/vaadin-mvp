package com.jrtech.tools.admins.views;

import com.jrtech.tools.admins.domain.Area;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.*;
import com.vaadin.ui.Tree.ExpandEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdministrativeViewImpl extends CustomComponent implements Tree.ExpandListener, AdministrativeView {

	private static final long serialVersionUID = 5685759058955122548L;
	public static final String NAME = "adminView";
	
	private Tree tree;
	private HorizontalSplitPanel panel;

	@Override
	public void enter(ViewChangeEvent event) {
		panel = new HorizontalSplitPanel();
		panel.setSplitPosition(25, Unit.PERCENTAGE);
		setCompositionRoot(panel);
        panel.setSizeFull();

        tree = new Tree();
        tree.addContainerProperty("name", String.class, "");
        tree.setItemCaptionPropertyId("name");
        tree.addExpandListener(this);

        Panel treePanel = new Panel();
        treePanel.setContent(tree);

        panel.setFirstComponent(treePanel);
        treePanel.setSizeFull();


        Panel map = new Panel();
        panel.setSecondComponent(map);
        panel.setSizeFull();

		
		for (AdministrativeViewListener listener : listeners){
			listener.enterView();
		}
		
	}

	@Override
	public void nodeExpand(ExpandEvent event) {
		if (tree.isRoot(event.getItemId())) {
			return;
		}
		
		for (AdministrativeViewListener listener : listeners) {
            listener.nodeExpand((String)event.getItemId());
        }
	}

	@Override
	public void initView(Area root) {
		tree.addItem(root.getCode());
		tree.getItem(root.getCode()).getItemProperty("name").setValue(root.getName());
        tree.setChildrenAllowed(root.getCode(), !root.getChildren().isEmpty());

        if (!root.getChildren().isEmpty()) {
            fillChildren(root.getCode(), root.getChildren());
        }

		tree.expandItem(root.getCode());
	}

	@Override
	public void expandNode(Area parent) {
        if (null != parent)
		    fillChildren(parent.getCode(), parent.getChildren());
	}

    private void fillChildren(String parentCode, List<Area> children) {
        for (Area admin : children) {
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
