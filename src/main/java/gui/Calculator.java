package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Calculator extends VBox implements EventHandler<ActionEvent>{

	String number1 = "";
	String number2 = "";
	String operator;
	Text displayText;

	public Calculator(){
		super(10);
		this.displayText = new Text();


		Rectangle rt = new Rectangle(250, 50, Color.TRANSPARENT);

		rt.setStroke(Color.GRAY);

		StackPane sp =  new StackPane(rt, this.displayText);

		sp.setPadding(new Insets(10, 10, 10, 10));

		GridPane gd = new GridPane();


		gd.setPadding(new Insets(10, 10, 10, 10));
		gd.setVgap(5);
		gd.setHgap(4);

		gd.setAlignment(Pos.CENTER);

		Button b7 = new Button("7");
		gd.add(b7, 0, 0);
		b7.setPrefWidth(50);
		b7.setOnAction(this);

		Button b8 = new Button("8");
		gd.add(b8, 1, 0);
		b8.setPrefWidth(50);
		b8.setOnAction(this);

		Button b9 = new Button("9");
		gd.add(b9, 2, 0);
		b9.setPrefWidth(50);
		b9.setOnAction(this);

		Button div = new Button("/");
		gd.add(div, 3, 0);
		div.setPrefWidth(50);
		div.setOnAction(this);

		Button b4 = new Button("4");
		gd.add(b4, 0, 1);
		b4.setPrefWidth(50);
		b4.setOnAction(this);

		Button b5 = new Button("5");
		gd.add(b5, 1, 1);
		b5.setPrefWidth(50);
		b5.setOnAction(this);

		Button b6 = new Button("6");
		gd.add(b6, 2, 1);
		b6.setPrefWidth(50);
		b6.setOnAction(this);

		Button mul = new Button("*");
		gd.add(mul, 3, 1);
		mul.setPrefWidth(50);
		mul.setOnAction(this);

		Button b1 = new Button("1");
		gd.add(b1, 0, 2);
		b1.setPrefWidth(50);
		b1.setOnAction(this);

		Button b2 = new Button("2");
		gd.add(b2, 1, 2);
		b2.setPrefWidth(50);
		b2.setOnAction(this);

		Button b3 = new Button("3");
		gd.add(b3, 2, 2);
		b3.setPrefWidth(50);
		b3.setOnAction(this);

		Button minus = new Button("-");
		gd.add(minus, 3, 2);
		minus.setPrefWidth(50);
		minus.setOnAction(this);

		Button b0 = new Button("0");
		gd.add(b0, 0, 3, 2, 1);
		b0.setPrefWidth(105);
		b0.setOnAction(this);

		Button plus = new Button("+");
		gd.add(plus, 2, 3);
		plus.setPrefWidth(50);
		plus.setOnAction(this);

		Button equals = new Button("=");
		gd.add(equals, 3, 3);
		equals.setPrefWidth(50);
		equals.setOnAction(this);

		Button reset = new Button("C");
		gd.add(reset, 0, 4, 4, 1);
		reset.setPrefWidth(215);
		reset.setOnAction(this);

		this.getChildren().addAll(sp, gd);

	}

	@Override
	public void handle(ActionEvent event) {

		Button b = (Button) event.getSource();
		String value = b.getText();


		if (value.equals("C")) {
			// Si se presiona el botón de reset, limpia las entradas
			number1 ="";
			number2 ="";
			operator = null;}
		if (value.matches("[0-9]") && operator != null){
			number2 += value;

		}if(value.matches("[0-9]") && operator == null) { // Si se presiona un botón de número
			// Si no se ha seleccionado un operador, agrega el valor al número1
			number1 += value;

		}
		else if (value.equals("+") || value.equals("-")|| value.equals("/")|| value.equals("*")){
			if (!(number1.isEmpty())){
				operator = value;}
			else {
				displayText.setText("Debes iniciar con un numero");
			}
		}


		// Actualiza el texto de la pantalla
		if (operator!= null){
			displayText.setText(number1 + operator + number2);}
		else {
			displayText.setText(number1+ number2);
		}

		if (value.equals("=") && !(number1.isEmpty()) && !(number2.isEmpty()) && operator!= null){
			int number1int = Integer.parseInt(number1);
			int number2int = Integer.parseInt(number2);
			if (operator.equals("+")){
				int operacion1 = number1int+number2int;
				displayText.setText(Integer.toString(operacion1));
			}
			else if (operator.equals("-")){
				int operacion2 = number1int-number2int;
				displayText.setText(Integer.toString(operacion2));
			}
			else if (operator.equals("*")){
				int operacion3 = number1int*number2int;
				displayText.setText(Integer.toString(operacion3));
			}
			else if (operator.equals("/")){

				if (number2int == 0){
					displayText.setText("No puedes dividir entre cero");
				}
				else {
					int operacion4 = number1int/number2int;
					displayText.setText(Integer.toString(operacion4));
				}

			}


			number1 = "";
			number2 = "";
			operator = null;

		}
	}


}




