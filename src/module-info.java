/**
 * 
 */
/**
 * @author peedr
 *
 */
module TESTE
{
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.base;
	requires junit;
	opens app.controller to javafx.fxml, javafx.graphics;
	opens app.model;
	exports app;
}