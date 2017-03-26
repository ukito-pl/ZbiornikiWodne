/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZbiornikiWodne;

/**
 *
 * @author Marek Buła i Marcin Brachowski
 */
import java.awt.Color; 
import java.awt.BasicStroke; 
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 

import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class Okno extends javax.swing.JFrame {
    public double[] x1;
    public double[] y1;
    public double[] x2;
    public double[] y2;
    public double[] x3;
    public double[] y3;
    public double A1;   //pola przekrójów zwężek wyjściowych [m^2]
    public double A2;
    public double S1;   //pola przekroju walców [m^2]
    public double S2;
    public double H1;   //wysokość walców [m]
    public double H2;
    public double t;    //czas symulacji
    public double T;    //krok całkowania
    public int RP; //rodzaj pobudzenia
    public double AP; // amplituda pobudzenia
    public double TP; // okres pobudzenia
    public int RM; //rodzaj metody rozwiązywania równania różniczkowego
    public boolean PP;// czy pokazać pobudzenie
    
    
    /**
     * Creates new form Okno
     */
    public Okno() {
        initComponents();
        A1 = odbierz_wartosc( input_A1);
        A2 = odbierz_wartosc( input_A2);
        S1 = odbierz_wartosc( input_S1);
        H1 = odbierz_wartosc( input_H1);
        S2 = odbierz_wartosc( input_S2);
        H2 = odbierz_wartosc( input_H2);
        t = odbierz_wartosc( input_t);
        T = odbierz_wartosc( input_T);
        RP = input_RP.getSelectedIndex();
        AP = odbierz_wartosc(input_AP);
        TP = odbierz_wartosc(input_TP);
        RM = input_RM.getSelectedIndex();
        PP = input_PP.isSelected();
    }

    
     private XYDataset createDataset( double[] x, double[] y, boolean pobudzenie)
   {        
      final XYSeries h = new XYSeries( "h" );          
      for( int i = 0 ; i < x.length & i < y.length; i++){
          h.add( x[i] , y[i] );
      }

      final XYSeriesCollection dataset = new XYSeriesCollection( );                   
      dataset.addSeries( h );
      
      if(PP & pobudzenie){
        final XYSeries u = new XYSeries( "u" );          
        for( int i = 0 ; i < x3.length & i < y3.length; i++){
            u.add( x3[i] , y3[i] );
        }
        dataset.addSeries(u);
      }
      
      return dataset;
   }
     public void przeslij_dane(double[] otrzymane_x1, double[] otrzymane_y1,double[] otrzymane_x2, double[] otrzymane_y2,double[] otrzymane_x3, double[] otrzymane_y3){
         x1 = otrzymane_x1;
         y1 = otrzymane_y1;
         x2 = otrzymane_x2;
         y2 = otrzymane_y2;
         x3 = otrzymane_x3;
         y3 = otrzymane_y3;
     }
     
     private double odbierz_wartosc( javax.swing.JTextField zmienna_odebrana){
        double zmienna = 0.0;
        try{
            String str = zmienna_odebrana.getText();
            if (!str.isEmpty()){
                zmienna = Double.parseDouble(zmienna_odebrana.getText()) ;
            }
        }catch(java.lang.NumberFormatException e){
            
        }  
        return zmienna;
     }
     
    public void utworz_wykres(String nazwa, String nazwa_x, String nazwa_y, double[] x, double[] y, javax.swing.JPanel panel, boolean pobudzenie){
        
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
        nazwa ,
        nazwa_x,
        nazwa_y ,
        createDataset(x, y, pobudzenie) ,
        PlotOrientation.VERTICAL ,
        false , false , false);
        
        Color kolor = new Color(240,240,240);
        xylineChart.setBackgroundPaint(kolor);
        
        ChartPanel chartPanel = new ChartPanel( xylineChart );
        
        final XYPlot plot = xylineChart.getXYPlot( );
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.YELLOW );
        renderer.setSeriesStroke( 0 , new BasicStroke( 2.0f ) );
        renderer.setSeriesShapesVisible(0, jCheckBox1.isSelected());
        
        renderer.setSeriesPaint( 1 , Color.CYAN );
        renderer.setSeriesStroke( 1 , new BasicStroke( 2.0f ) );
        renderer.setSeriesShapesVisible(1, jCheckBox1.isSelected());
        
        plot.setRenderer( renderer ); 
        pack();
        panel.removeAll();
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.validate();
    
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        input_A1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        input_S1 = new javax.swing.JTextField();
        input_H1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        input_S2 = new javax.swing.JTextField();
        input_H2 = new javax.swing.JTextField();
        input_A2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        input_t = new javax.swing.JTextField();
        input_T = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        input_RP = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        input_AP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        input_TP = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        input_RM = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        input_PP = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        input_A1.setText("0.1");
        input_A1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_A1KeyReleased(evt);
            }
        });

        jButton1.setText("Start");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Parametry zbiorników");

        input_S1.setText("3");
        input_S1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_S1KeyReleased(evt);
            }
        });

        input_H1.setText("10");
        input_H1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_H1KeyReleased(evt);
            }
        });

        jLabel2.setText("S1");

        jLabel3.setText("H1");

        jLabel4.setText("A1");

        input_S2.setText("3");
        input_S2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_S2KeyReleased(evt);
            }
        });

        input_H2.setText("10");
        input_H2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_H2KeyReleased(evt);
            }
        });

        input_A2.setText("0.01");
        input_A2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_A2KeyReleased(evt);
            }
        });

        jLabel5.setText("S2");

        jLabel6.setText("H2");

        jLabel7.setText("A2");

        jLabel8.setText("Parametry symulacji");

        jLabel9.setText("Czas symulacji[s]");

        jLabel10.setText("Krok całkowania[s]");

        input_t.setText("200");
        input_t.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_tKeyReleased(evt);
            }
        });

        input_T.setText("1");
        input_T.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_TKeyReleased(evt);
            }
        });

        jLabel11.setText("Zaznacz momenty obliczeniowe");

        jLabel12.setText("Pobudzenie");

        jLabel13.setText("Rodzaj");

        input_RP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fala prostokątna", "Fala trójkątna", "Sinusoida" }));
        input_RP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_RPActionPerformed(evt);
            }
        });

        jLabel14.setText("Amplituda[m^3/s]");

        input_AP.setText("1");
        input_AP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_APKeyReleased(evt);
            }
        });

        jLabel15.setText("Okres[s]");

        input_TP.setText("100");
        input_TP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_TPKeyReleased(evt);
            }
        });

        jLabel16.setText("Metoda");

        input_RM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Metoda prostokątów", "Metoda trapezów", "l", " " }));
        input_RM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_RMActionPerformed(evt);
            }
        });

        jLabel17.setText("Pokaż pobudzenie");

        input_PP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_PPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(input_S1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(input_H1)
                                        .addComponent(input_A1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(input_S2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(input_H2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(input_A2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jCheckBox1)
                                            .addComponent(input_T, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                            .addComponent(input_t)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(input_RM, 0, 168, Short.MAX_VALUE)))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel14)
                                                .addComponent(jLabel15))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(input_TP, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                                .addComponent(input_AP)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(input_RP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(input_PP))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(143, 143, 143)
                                .addComponent(jLabel8)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(input_S2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(input_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(input_RP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(input_H2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(input_H1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10)
                                    .addComponent(input_T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(input_AP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(input_A1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(input_A2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jCheckBox1)
                                        .addComponent(jLabel11))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(input_TP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(input_S1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(input_RM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel17))
                    .addComponent(input_PP))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if (x1 != null & y1 != null){
        utworz_wykres("Wysokość wody w pierwszym zbiorniku", "Czas[s]", "Wysokość[m]", x1, y1,jPanel1, true);
        }
        if (x2 != null & y2 != null){
        utworz_wykres("Wysokość wody w drugim zbiorniku", "Czas[s]", "Wysokość[m]", x2, y2,jPanel2, false);
        }
    }//GEN-LAST:event_jButton1MouseClicked
    
   
    
    private void input_A1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_A1KeyReleased
        A1 = odbierz_wartosc( input_A1);
    }//GEN-LAST:event_input_A1KeyReleased

    private void input_A2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_A2KeyReleased
        A2 = odbierz_wartosc( input_A2);
    }//GEN-LAST:event_input_A2KeyReleased

    private void input_S1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_S1KeyReleased
        S1 = odbierz_wartosc( input_S1);
    }//GEN-LAST:event_input_S1KeyReleased

    private void input_H1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_H1KeyReleased
        H1 = odbierz_wartosc( input_H1);
    }//GEN-LAST:event_input_H1KeyReleased

    private void input_S2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_S2KeyReleased
        S2 = odbierz_wartosc( input_S2);
    }//GEN-LAST:event_input_S2KeyReleased

    private void input_H2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_H2KeyReleased
        H2 = odbierz_wartosc( input_H2);
    }//GEN-LAST:event_input_H2KeyReleased

    private void input_tKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_tKeyReleased
        t = odbierz_wartosc( input_t);
    }//GEN-LAST:event_input_tKeyReleased

    private void input_TKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_TKeyReleased
        T = odbierz_wartosc( input_T);
    }//GEN-LAST:event_input_TKeyReleased

    private void input_RPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_RPActionPerformed
        RP = input_RP.getSelectedIndex();
    }//GEN-LAST:event_input_RPActionPerformed

    private void input_APKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_APKeyReleased
        AP = odbierz_wartosc(input_AP);
    }//GEN-LAST:event_input_APKeyReleased

    private void input_TPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_TPKeyReleased
        TP = odbierz_wartosc(input_TP);
    }//GEN-LAST:event_input_TPKeyReleased

    private void input_RMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_RMActionPerformed
        RM = input_RM.getSelectedIndex();
    }//GEN-LAST:event_input_RMActionPerformed

    private void input_PPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_PPActionPerformed
        PP = input_PP.isSelected();
    }//GEN-LAST:event_input_PPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[], double[] dane_x, double[] dane_y) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Okno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Okno().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField input_A1;
    private javax.swing.JTextField input_A2;
    private javax.swing.JTextField input_AP;
    private javax.swing.JTextField input_H1;
    private javax.swing.JTextField input_H2;
    private javax.swing.JCheckBox input_PP;
    private javax.swing.JComboBox<String> input_RM;
    private javax.swing.JComboBox<String> input_RP;
    private javax.swing.JTextField input_S1;
    private javax.swing.JTextField input_S2;
    private javax.swing.JTextField input_T;
    private javax.swing.JTextField input_TP;
    private javax.swing.JTextField input_t;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
