package uz.uat.app.intercom.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;

public class SettingsLayout extends AppLayout {

    public SettingsLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();

    }

    private void addDrawerContent() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'decorateDrawer'");
        setPrimarySection(Section.NAVBAR);
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");
        
        addToNavbar(true, toggle);
    }
}
