package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class MenuButton extends Button {

    public MenuButton(String label) {
        super(label);
        this.setPrefWidth(100);
        this.setId("menuButton");
        this.setAlignment(Pos.CENTER);
    }
}
