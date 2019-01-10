/*
 * HowToPlay Class
 * @version: 12.05.2018
 * @author: Mehmet �mer Eyi
 */
package mainframes;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class HowToPlayFrame extends javax.swing.JFrame 
{
  
  // Variables declaration 
  private javax.swing.JButton backButton;
  private javax.swing.JLabel titleLabel;
  private javax.swing.JLabel instructionsLabel4;
  private javax.swing.JLabel noteLabel;
  private javax.swing.JLabel instructionsLabel6;
  private javax.swing.JLabel instructionLabel5;
  private javax.swing.JLabel madeByHumansLabel;
  private javax.swing.JLabel instructionsLabel9;
  private javax.swing.JLabel instructionLabel8;
  private javax.swing.JLabel instructionsLabel3;
  private javax.swing.JLabel instructionsLabel1;
  private javax.swing.JLabel instructionsLabel2;
  private javax.swing.JLabel instructionsLabel7;
  private javax.swing.JPanel jHowToPlayPanel;
  private JLabel lblSimulationWill;
  private JLabel lblToChangeTo;
  private JLabel lblToChangeTo_1;
  private JLabel lblToContinueThe;
  private JLabel lblGamePressExit;
  private JLabel lblYouWillBe;
  private JLabel lblInformationWithrearrange;
  
  //Constructor
  /**
   * Creates new form HowToPlayFrame
   */
  public HowToPlayFrame() 
  {
    initComponents();
  }
  
  //Methods
  /*
   * initComponents method
   * this method initializes the components
   */
  private void initComponents() 
  {
    
    instructionsLabel9 = new javax.swing.JLabel();
    jHowToPlayPanel = new javax.swing.JPanel();
    backButton = new javax.swing.JButton();
    madeByHumansLabel = new javax.swing.JLabel();
    instructionsLabel2 = new javax.swing.JLabel();
    titleLabel = new javax.swing.JLabel();
    instructionsLabel1 = new javax.swing.JLabel();
    instructionsLabel3 = new javax.swing.JLabel();
    noteLabel = new javax.swing.JLabel();
    instructionsLabel4 = new javax.swing.JLabel();
    instructionLabel5 = new javax.swing.JLabel();
    instructionsLabel6 = new javax.swing.JLabel();
    instructionsLabel7 = new javax.swing.JLabel();
    instructionLabel8 = new javax.swing.JLabel();
    
    instructionsLabel9.setText("jLabel3");
    
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("HowToPlay");
    
    jHowToPlayPanel.setLayout(null);
    
    backButton.setBackground(new java.awt.Color(0, 0, 0));
    backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/cooltext284157147984715.png")));
    backButton.addActionListener(new java.awt.event.ActionListener()
                                   {
      /*
       * actionPerformed method
       * @param ActionEvent evt
       */
      public void actionPerformed(java.awt.event.ActionEvent evt) 
      {
        backButtonActionPerformed(evt);
      }
    }
    );
    
    jHowToPlayPanel.add(backButton);
    backButton.setBounds(20, 390, 430, 40);
    
    madeByHumansLabel.setFont(new java.awt.Font("Tahoma", 1, 18));
    madeByHumansLabel.setForeground(new java.awt.Color(255, 0, 51));
    madeByHumansLabel.setText("@madeByHumans");
    jHowToPlayPanel.add(madeByHumansLabel);
    madeByHumansLabel.setBounds(660, 400, 180, 70);
    
    instructionsLabel2.setBackground(new java.awt.Color(0, 0, 0));
    instructionsLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14));
    instructionsLabel2.setForeground(new java.awt.Color(255, 255, 255));
    instructionsLabel2.setText("according to given information. You can randomize the");
    jHowToPlayPanel.add(instructionsLabel2);
    instructionsLabel2.setBounds(30, 120, 394, 17);
    
    titleLabel.setBackground(new java.awt.Color(255, 255, 255));
    titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
    titleLabel.setForeground(new java.awt.Color(204, 0, 102));
    titleLabel.setText("HOW TO PLAY ");
    jHowToPlayPanel.add(titleLabel);
    titleLabel.setBounds(290, 20, 200, 40);
    
    instructionsLabel1.setBackground(new java.awt.Color(0, 0, 0));
    instructionsLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
    instructionsLabel1.setForeground(new java.awt.Color(255, 255, 255));
    instructionsLabel1.setText("2. Calculate the speed of the ball and direction of the ball ");
    jHowToPlayPanel.add(instructionsLabel1);
    instructionsLabel1.setBounds(30, 100, 374, 17);
    
    instructionsLabel3.setBackground(new java.awt.Color(0, 0, 0));
    instructionsLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
    instructionsLabel3.setForeground(new java.awt.Color(255, 255, 255));
    instructionsLabel3.setText("1.  Select a map.");
    jHowToPlayPanel.add(instructionsLabel3);
    instructionsLabel3.setBounds(30, 80, 120, 17);
    
    noteLabel.setBackground(new java.awt.Color(0, 0, 0));
    noteLabel.setFont(new java.awt.Font("Times New Roman", 1, 14));
    noteLabel.setForeground(new java.awt.Color(255, 255, 255));
    noteLabel.setText("Notes: If you are struggling with calculations ");
    jHowToPlayPanel.add(noteLabel);
    noteLabel.setBounds(30, 351, 290, 17);
    
    instructionsLabel4.setBackground(new java.awt.Color(0, 0, 0));
    instructionsLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
    instructionsLabel4.setForeground(new java.awt.Color(255, 255, 255));
    instructionsLabel4.setText("5. If shot missed the post then simulation will stop. To exit the ");
    jHowToPlayPanel.add(instructionsLabel4);
    instructionsLabel4.setBounds(30, 270, 394, 17);
    
    instructionLabel5.setBackground(new java.awt.Color(0, 0, 0));
    instructionLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
    instructionLabel5.setForeground(new java.awt.Color(255, 255, 255));
    instructionLabel5.setText("In-game calculator is provided for you.");
    jHowToPlayPanel.add(instructionLabel5);
    instructionLabel5.setBounds(30, 368, 270, 17);
    
    instructionsLabel6.setBackground(new java.awt.Color(0, 0, 0));
    instructionsLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14));
    instructionsLabel6.setForeground(new java.awt.Color(255, 255, 255));
    instructionsLabel6.setText("you can use hint buttons.");
    jHowToPlayPanel.add(instructionsLabel6);
    instructionsLabel6.setBounds(310, 351, 190, 17);
    
    instructionsLabel7.setBackground(new java.awt.Color(0, 0, 0));
    instructionsLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
    instructionsLabel7.setForeground(new java.awt.Color(255, 255, 255));
    instructionsLabel7.setText("3. Hit the \"Approve\" and wait to game begin.");
    jHowToPlayPanel.add(instructionsLabel7);
    instructionsLabel7.setBounds(30, 160, 320, 17);
    
    lblSimulationWill = new JLabel();
    lblSimulationWill.setText("4. Simulation will start. To move camera use the mouse.\r\nTo change to free camera view press F, to bind the camera to \r\nthe ball press B. To stop the simulation press P, to continue press C.");
    lblSimulationWill.setForeground(Color.WHITE);
    lblSimulationWill.setFont(new Font("Times New Roman", Font.BOLD, 14));
    lblSimulationWill.setBackground(Color.BLACK);
    lblSimulationWill.setBounds(30, 183, 394, 17);
    jHowToPlayPanel.add(lblSimulationWill);
    
    lblToChangeTo = new JLabel();
    lblToChangeTo.setText("To change to free camera view press F, to bind the camera \r\nto");
    lblToChangeTo.setForeground(Color.WHITE);
    lblToChangeTo.setFont(new Font("Times New Roman", Font.BOLD, 14));
    lblToChangeTo.setBackground(Color.BLACK);
    lblToChangeTo.setBounds(30, 205, 394, 17);
    jHowToPlayPanel.add(lblToChangeTo);
    
    lblToChangeTo_1 = new JLabel();
    lblToChangeTo_1.setText("the ball press B. To stop the simulation press P,");
    lblToChangeTo_1.setForeground(Color.WHITE);
    lblToChangeTo_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
    lblToChangeTo_1.setBackground(Color.BLACK);
    lblToChangeTo_1.setBounds(30, 218, 394, 34);
    jHowToPlayPanel.add(lblToChangeTo_1);
    
    lblToContinueThe = new JLabel();
    lblToContinueThe.setText("To continue the simulation press C");
    lblToContinueThe.setForeground(Color.WHITE);
    lblToContinueThe.setFont(new Font("Times New Roman", Font.BOLD, 14));
    lblToContinueThe.setBackground(Color.BLACK);
    lblToContinueThe.setBounds(30, 240, 394, 34);
    jHowToPlayPanel.add(lblToContinueThe);
    
    lblGamePressExit = new JLabel();
    lblGamePressExit.setText("game press exit button on the frame. After pressing the button");
    lblGamePressExit.setForeground(Color.WHITE);
    lblGamePressExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
    lblGamePressExit.setBackground(Color.BLACK);
    lblGamePressExit.setBounds(30, 290, 394, 17);
    jHowToPlayPanel.add(lblGamePressExit);
    
    lblYouWillBe = new JLabel();
    lblYouWillBe.setText("you will be asked for play again or not. ");
    lblYouWillBe.setForeground(Color.WHITE);
    lblYouWillBe.setFont(new Font("Times New Roman", Font.BOLD, 14));
    lblYouWillBe.setBackground(Color.BLACK);
    lblYouWillBe.setBounds(30, 308, 394, 17);
    jHowToPlayPanel.add(lblYouWillBe);
    
    lblInformationWithrearrange = new JLabel();
    lblInformationWithrearrange.setText("information with \"Rearrange\" button.");
    lblInformationWithrearrange.setForeground(Color.WHITE);
    lblInformationWithrearrange.setFont(new Font("Times New Roman", Font.BOLD, 14));
    lblInformationWithrearrange.setBackground(Color.BLACK);
    lblInformationWithrearrange.setBounds(30, 140, 394, 17);
    jHowToPlayPanel.add(lblInformationWithrearrange);
    
    instructionLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images2/midweekfootballfreebet.jpg")));
    jHowToPlayPanel.add(instructionLabel8);
    instructionLabel8.setBounds(0, -10, 880, 510);
    
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
                              layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup().addComponent(jHowToPlayPanel,
                                                                                      javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)));
    layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                                                                                                           javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                           layout.createSequentialGroup().addContainerGap().addComponent(jHowToPlayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE).addContainerGap()));
    pack();
  }
  /*
   * backButtonActionPeformed method
   * this method closes the frame
   *@param ActionEvent evt
   */
  
  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) 
  {
    new MainFrame().setVisible(true);
    this.dispose();
  }
}
