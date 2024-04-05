/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unindra.kkp_kelompok4;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import edu.unindra.kkp_kelompok4.login.formLogin;
import java.util.Locale;
import javax.swing.UIManager;

/**
 *
 * @author ripal
 */
public class main {
    public static void main(String[] args) {
	    Locale.setDefault(new Locale("id"));
	    
	     try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
	    UIManager.put( "Button.arc", 999 );
	    UIManager.put( "Component.arc", 999 );
	    UIManager.put( "TextComponent.arc", 999 );
	    
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf");
        }
       java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new formLogin().setVisible(true);
			}
		});
    }
}
