package com.jrtech.tools.admins.presenter;

import com.jrtech.tools.admins.domain.Administrative;
import com.jrtech.tools.admins.domain.Country;
import com.jrtech.tools.admins.repository.AdministrativeRepository;
import com.jrtech.tools.admins.repository.CountryRepository;
import com.jrtech.tools.admins.views.AdministrativeView;
import com.vaadin.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Component
@UIScope
public class AdministrativePresenter implements AdministrativeView.EnterViewListener, AdministrativeView.ItemExpandListener {

    private AdministrativeView view;
    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    private CountryRepository counrtyRepo;
    @Autowired
	private AdministrativeRepository adminRepo;

    public void setView(AdministrativeView view) {
        this.view = view;
        this.view.addInitListener(this);
        this.view.addExpandListener(this);
    }

    @Override
    public void enterView() {
        TransactionTemplate template = new TransactionTemplate(transactionManager);
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                Country china = counrtyRepo.findOne("156");
                view.initView(china);
            }
        });
    }

    @Override
    public void nodeExpand(String itemId) {
        TransactionTemplate template = new TransactionTemplate(transactionManager);
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                Administrative admin = adminRepo.findOne(itemId);
                view.expandView(admin);
            }
        });
    }
}
