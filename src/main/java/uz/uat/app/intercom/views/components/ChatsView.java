package uz.uat.app.intercom.views.components;

import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import uz.uat.app.intercom.model.entity.Chat;
import uz.uat.app.intercom.model.entity.ChatService;
import uz.uat.app.intercom.model.entity.chats.ChatTypes;
import uz.uat.app.intercom.views.SettingsLayout;

@PageTitle(value = "Редактирование чатов")
@Route(value = "chats", layout = SettingsLayout.class)
public class ChatsView extends VerticalLayout {
    private ChatService service;
    private GridCrud<Chat> crud;
    private GridListDataView<Chat> listDataView;
    private Chat chat;

    public ChatsView(ChatService service) {
        this.service = service;
        crud();
        add(crud);
    }

    private void crud() {
        this.crud = new GridCrud<>(Chat.class);
        crud.setAddOperation(service::save);
        crud.setUpdateOperation(service::save);
        crud.setDeleteOperation(service::delete);
        crud.setFindAllOperation(service::findAll);

        Grid<Chat> grid = crud.getGrid();
        grid.setColumns("name", "type", "image");

        grid.getColumnByKey("name").setHeader("Наименование");
        grid.getColumnByKey("type").setHeader("Тип");
        grid.getColumnByKey("image").setHeader("Аватар");

        grid.getSelectionModel().addSelectionListener(sel -> {
                this.chat = grid.getSelectionModel().getFirstSelectedItem().orElse(new Chat());
        });

        listDataView = grid.getListDataView();

        crud.getCrudFormFactory().setVisibleProperties("name", "type", "image", "tags");
        crud.getCrudFormFactory().setFieldCaptions("Наименование", "Тип", "Аватар", "Тэги");

        crud.getCrudFormFactory().setFieldProvider("type", combo -> new ComboBox<>("Тип", ChatTypes.toList()));

    }

}
