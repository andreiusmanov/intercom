package uz.uat.app.intercom.views.department;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.CrudFormFactory;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import uz.uat.app.intercom.controller.DepartmentService;
import uz.uat.app.intercom.model.entity.account.Department;
import uz.uat.app.intercom.views.AdminLayout;

@PageTitle("Отделы")
@Route(value = "intercom/departments", layout = AdminLayout.class)
public class DepartmentView extends VerticalLayout {

    private DepartmentService service;
    private GridCrud<Department> crud;

    public DepartmentView(DepartmentService service) {
        this.service = service;
        crud();
        add(crud);
    }

    private void crud() {
        this.crud = new GridCrud<>(Department.class);
        crud.setAddOperation(service::save);
        crud.setUpdateOperation(service::save);
        crud.setDeleteOperation(service::delete);
        crud.setFindAllOperation(service::findAll);

        Grid<Department> grid = crud.getGrid();
        grid.setColumns("code", "shortName", "name");
        grid.getColumnByKey("code").setHeader("Код");
        grid.getColumnByKey("shortName").setHeader("Аббрев.");
        grid.getColumnByKey("name").setHeader("Наименование");

        crud.getCrudFormFactory().setFieldCaptions("Код", "Аббрев.", "Наименование");
        crud.getCrudFormFactory().setVisibleProperties("code", "shortName", "name");

        crud.getCrudFormFactory().setFieldType("name", TextArea.class);

        CrudFormFactory<Department> c = crud.getCrudFormFactory();
    }

}
