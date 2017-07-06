package es.cic.taller.ejercicio05;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField nombre = new TextField();
        nombre.setPlaceholder("Escribe tu nombre aqui:");
        nombre.setCaption("Nombre:");
        
        final TextField apellido = new TextField();
        apellido.setPlaceholder("Escribe tus apellidos aqui:");
        apellido.setCaption("Apellidos");
        
        final TextField edad = new TextField();
        edad.setPlaceholder("Escribe tu edad aqui:");
        edad.setCaption("Edad");
        
        final TextField direccion = new TextField();
        direccion.setPlaceholder("Escribe tu dirección aqui:");
        direccion.setCaption("Dirección");
        
        Button button = new Button("Pulsa");
        button.addClickListener( e -> {
        	Notification.show("Te llamas " + nombre.getValue() + " " + apellido.getValue() 
                    + " tienes " + edad.getValue() + " años" + " y vives en " + direccion.getValue());
        });
        
        /*sample.addValueChangeListener(event -> Notification.show("Value changed:",
                String.valueOf(event.getValue()),
                Type.TRAY_NOTIFICATION));*/
        layout.addComponents(nombre, apellido, edad, direccion, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
