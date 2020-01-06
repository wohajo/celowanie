package view.menuComponents;

import components.abstracts.Element;
import components.gameObjects.Arrow;
import components.gameObjects.Block;
import components.gameObjects.Cell;
import javafx.scene.layout.GridPane;

public class GameGrid extends GridPane {

    private GridPane gameGrid;

    public GameGrid(int dim) {
        this.gameGrid = new GridPane();
        for (int x = 0; x < dim; x++)
            for (int y = 0; y < dim; y++) {
                if (x == 0 || x == dim - 1 || y == 0 || y == dim - 1) {
                    if ( (x == 0 && y == 0) || (x == 0 && y == dim - 1) || (x == dim - 1 && y == 0) || (x == dim - 1 && y == dim - 1)) {
                        Block block = new Block(x, y);
                        this.gameGrid.addRow(y, block);
                    } else {
                        if (y == 0) {
                            Arrow arrow = new Arrow(x, y);
                            this.gameGrid.addRow(y, arrow);
                        } else if (x == 0) {
                            Arrow arrow = new Arrow(x, y);
                            arrow.setStyle("-fx-background-image: url(/rsc/arrowRight.png)");
                            this.gameGrid.addRow(y, arrow);
                        } else if ( y == 6) {
                            Arrow arrow = new Arrow(x, y);
                            arrow.setStyle("-fx-background-image: url(/rsc/arrowUp.png)");
                            this.gameGrid.addRow(y, arrow);
                        } else {
                            Arrow arrow = new Arrow(x, y);
                            arrow.setStyle("-fx-background-image: url(/rsc/arrowLeft.png)");
                            this.gameGrid.addRow(y, arrow);
                        }

                    }
                } else {
                    Cell cell = new Cell(x, y, y);
                    cell.changeLabel(cell.getValue());
                    cell.setOnAction(e -> {
                        cell.valueDec();
                        cell.changeLabel(cell.getValue());
                    });
                    this.gameGrid.addRow(y, cell);
                }
            };
    }

    public GameGrid(int dim, Element[][] Elements) {
        this.gameGrid = new GridPane();
        for (int x = 0; x < dim; x++)
            for (int y = 0; y < dim; y++) {
                if (x == 0 || x == dim - 1 || y == 0 || y == dim - 1) {
                    if ( (x == 0 && y == 0) || (x == 0 && y == dim - 1) || (x == dim - 1 && y == 0) || (x == dim - 1 && y == dim - 1)) {
                       /* Block block = new Block(x, y);
                        this.gameGrid.addRow(y, block);*/
                        this.gameGrid.addRow(y, Elements[x][y]);
                    } else {
                        if (y == 0) {
                            /*Arrow arrow = new Arrow(x, y);
                            this.gameGrid.addRow(y, arrow);*/
                            this.gameGrid.addRow(y, Elements[x][y]);
                        } else if (x == 0) {
                           /* Arrow arrow = new Arrow(x, y);
                            arrow.setStyle("-fx-background-image: url(/rsc/arrowRight.png)");
                            this.gameGrid.addRow(y, arrow);*/
                            this.gameGrid.addRow(y, Elements[x][y]);
                        } else if ( y == 6) {
                           /* Arrow arrow = new Arrow(x, y);
                            arrow.setStyle("-fx-background-image: url(/rsc/arrowUp.png)");
                            this.gameGrid.addRow(y, arrow);*/
                            this.gameGrid.addRow(y, Elements[x][y]);
                        } else {
                            /*Arrow arrow = new Arrow(x, y);
                            arrow.setStyle("-fx-background-image: url(/rsc/arrowLeft.png)");
                            this.gameGrid.addRow(y, arrow);*/
                            this.gameGrid.addRow(y, Elements[x][y]);
                        }

                    }
                } else {
                    this.gameGrid.addRow(y, Elements[x][y]);
                   /* Cell cell = new Cell(x, y, y);
                    cell.changeLabel(cell.getValue());
                    cell.setOnAction(e -> {
                        cell.valueDec();
                        cell.changeLabel(cell.getValue());
                    });
                    this.gameGrid.addRow(y, cell);*/
                }
            };
        /*this.gameGrid = new GridPane();
        for (int x = 0; x < dim; x++)
            for (int y = 0; y < dim; y++) {
                if (x == 0 || x == dim - 1 || y == 0 || y == dim - 1) {
                    if ( (x == 0 && y == 0) || (x == 0 && y == dim - 1) || (x == dim - 1 && y == 0) || (x == dim - 1 && y == dim - 1)) {
                        this.gameGrid.addRow(y, Elements[x][y]);
                    } else {
                        this.gameGrid.addRow(y, Elements[x][y]);
                    }
                } else {
                    this.gameGrid.addRow(y, Elements[x][y]);
                }
            };*/
    }

    public GridPane getGameGrid() {
        return gameGrid;
    }

    public void setGameGrid(Element[][] elements) {
        this.gameGrid = new GameGrid(7, elements);
    }
}
