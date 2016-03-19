/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meteoinfo.legend;

import org.meteoinfo.layout.MapLayout;
import org.meteoinfo.map.MapView;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JColorChooser;
import org.meteoinfo.global.event.ISelectedCellChangedListener;
import org.meteoinfo.global.event.SelectedCellChangedEvent;

/**
 *
 * @author User
 */
public class FrmPolygonSymbolSet extends javax.swing.JDialog {

    private Object _parent = null;
    private PolygonBreak _polygonBreak = null;
    private boolean isLoading = false;

    /**
     * Creates new form FrmPolygonSymbolSet
     * @param parent
     * @param modal
     */
    public FrmPolygonSymbolSet(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setTitle("Polygon Symbol Set");                
    }

    /**
     *
     * @param parent
     * @param modal
     * @param tparent
     */
    public FrmPolygonSymbolSet(java.awt.Dialog parent, boolean modal, Object tparent) {
        super(parent, modal);
        initComponents();
        this._parent = tparent;

        this.setTitle("Polygon Symbol Set");
        if (tparent.getClass() == LegendView.class) {
            this.jButton_Apply.setVisible(false);
            this.jButton_OK.setVisible(false);
            this.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - 40));
        }
        
        this.symbolControl1.addSelectedCellChangedListener(new ISelectedCellChangedListener() {
            @Override
            public void selectedCellChangedEvent(SelectedCellChangedEvent event) {
                onSelectedCellChanged(event);
            }
        });
    }
    
    private void onSelectedCellChanged(SelectedCellChangedEvent event) {
        if (isLoading) {
            return;
        }

        this._polygonBreak.setStyle(HatchStyle.values()[symbolControl1.getSelectedCell()]);
        if (_parent.getClass() == LegendView.class) {
            ((LegendView) _parent).setLegendBreak_PolygonStyle(this._polygonBreak.getStyle());
        }
    }

    /**
     *
     * @param parent
     * @param modal
     * @param tparent
     */
    public FrmPolygonSymbolSet(java.awt.Frame parent, boolean modal, Object tparent) {
        super(parent, modal);
        initComponents();
        this._parent = tparent;

        this.setTitle("Polygon Symbol Set");
        if (tparent.getClass() == LegendView.class) {
            this.jButton_Apply.setVisible(false);
            this.jButton_OK.setVisible(false);
            this.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - 40));
        }
        
        this.symbolControl1.addSelectedCellChangedListener(new ISelectedCellChangedListener() {
            @Override
            public void selectedCellChangedEvent(SelectedCellChangedEvent event) {
                onSelectedCellChanged(event);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox_DrawShape = new javax.swing.JCheckBox();
        jCheckBox_DrawFill = new javax.swing.JCheckBox();
        jCheckBox_DrawOutline = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSpinner_OutlineSize = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel_OutlineColor = new javax.swing.JLabel();
        jButton_OK = new javax.swing.JButton();
        jButton_Apply = new javax.swing.JButton();
        jLabel_FillColor = new javax.swing.JLabel();
        jLabel_BackColor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSpinner_TransParency = new javax.swing.JSpinner();
        symbolControl1 = new org.meteoinfo.legend.SymbolControl();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jCheckBox_DrawShape.setText("Draw Shape");
        jCheckBox_DrawShape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DrawShapeActionPerformed(evt);
            }
        });

        jCheckBox_DrawFill.setText("Draw Fill");
        jCheckBox_DrawFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DrawFillActionPerformed(evt);
            }
        });

        jCheckBox_DrawOutline.setText("Draw Outline");
        jCheckBox_DrawOutline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_DrawOutlineActionPerformed(evt);
            }
        });

        jLabel1.setText("Fill Color:");

        jLabel2.setText("Back Color:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Outline"));
        jPanel1.setToolTipText("Outline");
        jPanel1.setName("Outline"); // NOI18N

        jLabel3.setText("Size:");

        jSpinner_OutlineSize.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(100.0f), Float.valueOf(0.5f)));
        jSpinner_OutlineSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_OutlineSizeStateChanged(evt);
            }
        });

        jLabel4.setText("Color:");

        jLabel_OutlineColor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_OutlineColor.setOpaque(true);
        jLabel_OutlineColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_OutlineColorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner_OutlineSize, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_OutlineColor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_OutlineColor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jSpinner_OutlineSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_OK.setText("OK");
        jButton_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_OKActionPerformed(evt);
            }
        });

        jButton_Apply.setText("Apply");
        jButton_Apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ApplyActionPerformed(evt);
            }
        });

        jLabel_FillColor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_FillColor.setOpaque(true);
        jLabel_FillColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_FillColorMouseClicked(evt);
            }
        });

        jLabel_BackColor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_BackColor.setOpaque(true);
        jLabel_BackColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BackColorMouseClicked(evt);
            }
        });

        jLabel5.setText("TransParency:");

        jSpinner_TransParency.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 10));
        jSpinner_TransParency.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_TransParencyStateChanged(evt);
            }
        });

        symbolControl1.setCellSize(new java.awt.Dimension(50, 40));
        symbolControl1.setPreferredSize(new java.awt.Dimension(200, 50));
        symbolControl1.setShapeType(org.meteoinfo.shape.ShapeTypes.Polygon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton_Apply, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_DrawOutline)
                            .addComponent(jCheckBox_DrawFill)
                            .addComponent(jCheckBox_DrawShape))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_FillColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_BackColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner_TransParency, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(symbolControl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(symbolControl1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox_DrawShape)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_DrawFill)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox_DrawOutline))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jSpinner_TransParency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_FillColor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_BackColor, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_OK)
                    .addComponent(jButton_Apply))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_FillColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_FillColorMouseClicked
        // TODO add your handling code here:
        Color c = JColorChooser.showDialog(rootPane, null, this.jLabel_FillColor.getBackground());
        if (c == null)
            return;
        
        int trans = Integer.parseInt(this.jSpinner_TransParency.getValue().toString());
        trans = (int)((1 - trans / 100.0) * 255);
        Color aColor = new Color(c.getRed(), c.getGreen(), c.getBlue(), trans);
        this.jLabel_FillColor.setBackground(aColor);
        _polygonBreak.setColor(aColor);
        if (_parent.getClass() == LegendView.class) {
            //((LegendView) _parent).setLegendBreak_Color(aColor);
            ((LegendView) _parent).repaint();
        }
    }//GEN-LAST:event_jLabel_FillColorMouseClicked

    private void jCheckBox_DrawShapeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DrawShapeActionPerformed
        // TODO add your handling code here:
        _polygonBreak.setDrawShape(this.jCheckBox_DrawShape.isSelected());
        if (_parent.getClass() == LegendView.class) {
            ((LegendView) _parent).setLegendBreak_DrawShape(this.jCheckBox_DrawShape.isSelected());
        }
    }//GEN-LAST:event_jCheckBox_DrawShapeActionPerformed

    private void jCheckBox_DrawFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DrawFillActionPerformed
        // TODO add your handling code here:
        _polygonBreak.setDrawFill(this.jCheckBox_DrawFill.isSelected());
        if (_parent.getClass() == LegendView.class) {
            //((LegendView) _parent).setLegendBreak_DrawFill(this.jCheckBox_DrawFill.isSelected());
            ((LegendView) _parent).repaint();
        }
    }//GEN-LAST:event_jCheckBox_DrawFillActionPerformed

    private void jCheckBox_DrawOutlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_DrawOutlineActionPerformed
        // TODO add your handling code here:
        _polygonBreak.setDrawOutline(this.jCheckBox_DrawOutline.isSelected());
        if (_parent.getClass() == LegendView.class) {
            ((LegendView) _parent).setLegendBreak_DrawOutline(this.jCheckBox_DrawOutline.isSelected());
        }
    }//GEN-LAST:event_jCheckBox_DrawOutlineActionPerformed

    private void jLabel_BackColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BackColorMouseClicked
        // TODO add your handling code here:
        Color aColor = JColorChooser.showDialog(rootPane, null, this.jLabel_BackColor.getBackground());
        if (aColor != null){
            this.jLabel_BackColor.setBackground(aColor);
            _polygonBreak.setBackColor(aColor);
            if (_parent.getClass() == LegendView.class) {
                ((LegendView) _parent).setLegendBreak_BackColor(aColor);
            }
        }
    }//GEN-LAST:event_jLabel_BackColorMouseClicked

    private void jLabel_OutlineColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_OutlineColorMouseClicked
        // TODO add your handling code here:
        Color aColor = JColorChooser.showDialog(rootPane, null, this.jLabel_OutlineColor.getBackground());
        this.jLabel_OutlineColor.setBackground(aColor);
        _polygonBreak.setOutlineColor(aColor);
        if (_parent.getClass() == LegendView.class) {
            ((LegendView) _parent).setLegendBreak_OutlineColor(aColor);
        }
    }//GEN-LAST:event_jLabel_OutlineColorMouseClicked

    private void jSpinner_OutlineSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_OutlineSizeStateChanged
        // TODO add your handling code here:
        float size = Float.parseFloat(this.jSpinner_OutlineSize.getValue().toString());
        _polygonBreak.setOutlineSize(size);
        if (_parent.getClass() == LegendView.class) {
            ((LegendView) _parent).setLegendBreak_OutlineSize(size);
        }
    }//GEN-LAST:event_jSpinner_OutlineSizeStateChanged

    private void jButton_ApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ApplyActionPerformed
        // TODO add your handling code here:
        if (_parent.getClass() == MapView.class) {
            ((MapView) _parent).paintLayers();
        } else if (_parent.getClass() == MapLayout.class) {
            ((MapLayout) _parent).paintGraphics();
        }
    }//GEN-LAST:event_jButton_ApplyActionPerformed

    private void jButton_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_OKActionPerformed
        // TODO add your handling code here:
        if (_parent.getClass() == MapView.class) {
            ((MapView) _parent).setDefPolygonBreak(_polygonBreak);
            ((MapView) _parent).paintLayers();
        } else if (_parent.getClass() == MapLayout.class) {
            ((MapLayout) _parent).setDefPolygonBreak(_polygonBreak);
            ((MapLayout) _parent).paintGraphics();
        }

        this.dispose();
    }//GEN-LAST:event_jButton_OKActionPerformed

    private void jSpinner_TransParencyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_TransParencyStateChanged
        // TODO add your handling code here:
        int alpha = Integer.parseInt(this.jSpinner_TransParency.getValue().toString());
        alpha = (int)((1 - alpha / 100.0) * 255);
        Color c = _polygonBreak.getColor();
        c = new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha);
        _polygonBreak.setColor(c);
        if (_parent.getClass() == LegendView.class) {
            ((LegendView) _parent).setLegendBreak_Color_Transparency(alpha);
        }
    }//GEN-LAST:event_jSpinner_TransParencyStateChanged

    /**
     * Set polygon break
     *
     * @param pgb The polygon break
     */
    public void setPolygonBreak(PolygonBreak pgb) {
        _polygonBreak = pgb;

        updateProperties();
    }

    private void updateProperties() {
        isLoading = true;

        this.jLabel_FillColor.setBackground(_polygonBreak.getColor());
        this.jCheckBox_DrawShape.setSelected(_polygonBreak.isDrawShape());
        int trans = (int)((1 - (double)_polygonBreak.getColor().getAlpha() / 255) * 100);
        this.jSpinner_TransParency.setValue(trans);
        this.jCheckBox_DrawFill.setSelected(_polygonBreak.isDrawFill());
        this.jCheckBox_DrawOutline.setSelected(_polygonBreak.isDrawOutline());
        this.jSpinner_OutlineSize.setValue(_polygonBreak.getOutlineSize());
        this.jLabel_OutlineColor.setBackground(_polygonBreak.getOutlineColor());

//            symbolControl1.SymbolNumber = Enum.GetNames(typeof(HatchStyle)).Length + 1;
//            if (_polygonBreak.UsingHatchStyle)
//                symbolControl1.SelectedCell = Array.IndexOf(Enum.GetNames(typeof(HatchStyle)), _polygonBreak.Style.ToString()) + 1;
//            else
//                symbolControl1.SelectedCell = 0;
//
//            if (symbolControl1.SelectedCell == 0)
//            {
//                _polygonBreak.UsingHatchStyle = false;
//                B_BackColor.Enabled = false;
//            }
//            else
//            {
//                _polygonBreak.UsingHatchStyle = true;
//                _polygonBreak.Style = (HatchStyle)(Enum.GetValues(typeof(HatchStyle)).GetValue(symbolControl1.SelectedCell - 1));
//                B_BackColor.Enabled = true;
//            }

        isLoading = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(FrmPolygonSymbolSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPolygonSymbolSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPolygonSymbolSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPolygonSymbolSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPolygonSymbolSet dialog = new FrmPolygonSymbolSet(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Apply;
    private javax.swing.JButton jButton_OK;
    private javax.swing.JCheckBox jCheckBox_DrawFill;
    private javax.swing.JCheckBox jCheckBox_DrawOutline;
    private javax.swing.JCheckBox jCheckBox_DrawShape;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_BackColor;
    private javax.swing.JLabel jLabel_FillColor;
    private javax.swing.JLabel jLabel_OutlineColor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner_OutlineSize;
    private javax.swing.JSpinner jSpinner_TransParency;
    private org.meteoinfo.legend.SymbolControl symbolControl1;
    // End of variables declaration//GEN-END:variables
}
