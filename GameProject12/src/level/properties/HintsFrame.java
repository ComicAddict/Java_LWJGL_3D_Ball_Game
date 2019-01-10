/*
 * Hints frame class Class
 * @author Çaðan Önen
 * @version 12/05/2018
 */
package level.properties;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.BorderLayout;

// ------------------------------------------
public class HintsFrame extends javax.swing.JFrame 
{
  
  // Properties
  private javax.swing.JButton backButton;
  private javax.swing.JLabel hintLabel;
  private javax.swing.JScrollPane hintPane;
  private javax.swing.JTextArea hintText;
  private final LevelProperties outer;
  
  /**
   * Creates new form HintsFrame
   */
  public HintsFrame ( final LevelProperties outer ) 
  {
    this.outer = outer;
    setLayout ( new BorderLayout() );
    initComponents();
    
    setTitle ("WE ARE HERE TO HELP YOU!");
    setSize ( 500, 500 );
    setResizable ( false );
    setDefaultCloseOperation ( javax.swing.WindowConstants.EXIT_ON_CLOSE );
  }
  
  /*
   * initializes some user interface components of the hints frame
   */
  private void initComponents() 
  {
    hintPane = new javax.swing.JScrollPane();
    hintPane.setSize ( 500,440 );
    add ( hintPane, BorderLayout.CENTER );
    
    hintText = new javax.swing.JTextArea();
    hintText.setText ( outer.displayHint() );
    hintPane.setViewportView ( hintText );
    hintText.setFont ( new java.awt.Font ( "Tahoma", 0, 19 ) );
    
    backButton = new javax.swing.JButton();
    backButton.setText ( "Back to Menu" );
    backButton.setFont ( new Font ( "Sitka Small", Font.BOLD, 14 ) );
    backButton.setBackground ( new Color ( 0,128,0 ) );
    
    
    hintLabel = new javax.swing.JLabel();
    hintLabel.setFont ( new java.awt.Font ( "Tahoma", 0, 22 ) );
    getContentPane().add ( hintLabel );
    hintLabel.setBounds ( 176, 35, 63, 27 );
    
    
    backButton.addActionListener(new java.awt.event.ActionListener() 
                                   {
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
        jButton1ActionPerformed(evt);
      }
    });
    
    add ( backButton, BorderLayout.SOUTH );
  }
  
  /**
   * closes the hint frame when clicked
   *
   * @param evt action event of the button
   */
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
  {
    this.dispose();
  }
  
}
