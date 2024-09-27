module Toure_projet {
	requires javafx.base;
	requires org.junit.jupiter.api;
	requires org.hamcrest;
	exports Application;
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires javafx.media;
	requires javafx.swing;
	//requires javafx.swt;
	requires javafx.web;
	requires java.sql;
	requires java.sql.rowset;
	requires java.xml;
	requires java.xml.crypto;
	
	
}