/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import esper.Config;
import events.ChooseFloorEvent;
import events.DoorEvent;
import events.EmergencyStopEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.DoorController;

/**
 *
 * @author Laptop Shop
 */
public class ElevatorUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public ElevatorUI() {
        initComponents();
        CallElevatorBtn1.setName("CallElevatorBtn1");
        CallElevatorBtn2.setName("CallElevatorBtn2");
        CallElevatorBtn3.setName("CallElevatorBtn3");

        Floor1btn.setName("Floor1btn");
        Floor2btn.setName("Floor2btn");
        Floor3btn.setName("Floor3btn");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ElevPanel = new javax.swing.JPanel();
        ElevatorControllerPanel = new javax.swing.JPanel();
        ElevatorPanel = new javax.swing.JLabel();
        Floor1btn = new javax.swing.JButton();
        Floor2btn = new javax.swing.JButton();
        Floor3btn = new javax.swing.JButton();
        StopBtn = new javax.swing.JButton();
        DoorBtn = new javax.swing.JButton();
        DoorStatus = new javax.swing.JLabel();
        doorStatusField = new javax.swing.JTextField();
        Light = new javax.swing.JLabel();
        LightOff = new javax.swing.JLabel();
        LightOn = new javax.swing.JLabel();
        LightPanel = new javax.swing.JPanel();
        CloseDoorBtn = new javax.swing.JButton();
        WeightLabel = new javax.swing.JLabel();
        WeightInput = new javax.swing.JTextField();
        Floor2 = new javax.swing.JLabel();
        Floor3 = new javax.swing.JLabel();
        CarPnel = new javax.swing.JPanel();
        Floor1 = new javax.swing.JLabel();
        CallPanl = new javax.swing.JPanel();
        Floor1Label = new javax.swing.JLabel();
        Floor2Label = new javax.swing.JLabel();
        Floor3Label = new javax.swing.JLabel();
        CallElevatorBtn3 = new javax.swing.JButton();
        CallElevatorBtn2 = new javax.swing.JButton();
        CallElevatorBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));

        ElevatorControllerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ElevatorPanel.setText("Elevator  Panel");

        Floor1btn.setText("Floor 1");
        Floor1btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Floor1btnActionPerformed(evt);
            }
        });

        Floor2btn.setText("Floor 2");
        Floor2btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Floor2btnActionPerformed(evt);
            }
        });

        Floor3btn.setText("Floor 3");
        Floor3btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Floor3btnActionPerformed(evt);
            }
        });

        StopBtn.setText("Emergency STOP");
        StopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopBtnActionPerformed(evt);
            }
        });

        DoorBtn.setText("Open Door");
        DoorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoorBtnActionPerformed(evt);
            }
        });

        DoorStatus.setText("Door Status");

        doorStatusField.setEditable(false);
        doorStatusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doorStatusFieldActionPerformed(evt);
            }
        });

        Light.setText("Light ");

        LightOff.setMaximumSize(new java.awt.Dimension(20, 20));
        LightOff.setMinimumSize(new java.awt.Dimension(20, 20));
        LightOff.setPreferredSize(new java.awt.Dimension(20, 20));

        LightOn.setMaximumSize(new java.awt.Dimension(20, 20));
        LightOn.setMinimumSize(new java.awt.Dimension(20, 20));
        LightOn.setPreferredSize(new java.awt.Dimension(20, 20));

        LightPanel.setBackground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout LightPanelLayout = new javax.swing.GroupLayout(LightPanel);
        LightPanel.setLayout(LightPanelLayout);
        LightPanelLayout.setHorizontalGroup(
            LightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        LightPanelLayout.setVerticalGroup(
            LightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        CloseDoorBtn.setText("Close Door");
        CloseDoorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseDoorBtnActionPerformed(evt);
            }
        });

        WeightLabel.setText("Weight");

        javax.swing.GroupLayout ElevatorControllerPanelLayout = new javax.swing.GroupLayout(ElevatorControllerPanel);
        ElevatorControllerPanel.setLayout(ElevatorControllerPanelLayout);
        ElevatorControllerPanelLayout.setHorizontalGroup(
            ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                        .addComponent(DoorStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doorStatusField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                        .addComponent(Light, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LightOn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LightOff, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                .addGroup(ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ElevatorPanel)
                            .addGroup(ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Floor3btn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Floor2btn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Floor1btn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DoorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CloseDoorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(WeightInput, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(WeightLabel)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ElevatorControllerPanelLayout.setVerticalGroup(
            ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                .addComponent(ElevatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Floor1btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Floor2btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Floor3btn)
                .addGap(18, 18, 18)
                .addComponent(StopBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DoorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseDoorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                        .addComponent(LightOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LightOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                        .addGroup(ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DoorStatus)
                            .addComponent(doorStatusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ElevatorControllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ElevatorControllerPanelLayout.createSequentialGroup()
                                .addComponent(Light)
                                .addGap(10, 10, 10))
                            .addComponent(LightPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addComponent(WeightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WeightInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Floor1.setIcon(new javax.swing.ImageIcon("M:\\ics\\rts\\RTS-Project\\RTS\\src\\view\\images\\Elevator.1.png")); // NOI18N

        javax.swing.GroupLayout CarPnelLayout = new javax.swing.GroupLayout(CarPnel);
        CarPnel.setLayout(CarPnelLayout);
        CarPnelLayout.setHorizontalGroup(
            CarPnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CarPnelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Floor1))
        );
        CarPnelLayout.setVerticalGroup(
            CarPnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CarPnelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Floor1))
        );

        Floor1Label.setText("Floor 1");

        Floor2Label.setText("Floor 2");

        Floor3Label.setText("Floor 3");

        CallElevatorBtn3.setText("CALL");
        CallElevatorBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CallElevatorBtn3ActionPerformed(evt);
            }
        });

        CallElevatorBtn2.setText("CALL");
        CallElevatorBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CallElevatorBtn2ActionPerformed(evt);
            }
        });

        CallElevatorBtn1.setText("CALL");
        CallElevatorBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CallElevatorBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CallPanlLayout = new javax.swing.GroupLayout(CallPanl);
        CallPanl.setLayout(CallPanlLayout);
        CallPanlLayout.setHorizontalGroup(
            CallPanlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CallPanlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CallPanlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CallPanlLayout.createSequentialGroup()
                        .addComponent(CallElevatorBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Floor1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CallPanlLayout.createSequentialGroup()
                        .addComponent(CallElevatorBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Floor2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CallPanlLayout.createSequentialGroup()
                        .addComponent(CallElevatorBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Floor3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        CallPanlLayout.setVerticalGroup(
            CallPanlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CallPanlLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(CallPanlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CallElevatorBtn3)
                    .addComponent(Floor3Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CallPanlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CallElevatorBtn2)
                    .addComponent(Floor2Label))
                .addGap(134, 134, 134)
                .addGroup(CallPanlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CallElevatorBtn1)
                    .addComponent(Floor1Label))
                .addGap(62, 62, 62))
        );

        jLabel1.setText("Request Elevator");

        javax.swing.GroupLayout ElevPanelLayout = new javax.swing.GroupLayout(ElevPanel);
        ElevPanel.setLayout(ElevPanelLayout);
        ElevPanelLayout.setHorizontalGroup(
            ElevPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ElevPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(ElevatorControllerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ElevPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ElevPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))
                    .addGroup(ElevPanelLayout.createSequentialGroup()
                        .addGroup(ElevPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ElevPanelLayout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addGroup(ElevPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Floor3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Floor2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ElevPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CarPnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170)))
                        .addComponent(CallPanl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))))
        );
        ElevPanelLayout.setVerticalGroup(
            ElevPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ElevPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(ElevPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ElevatorControllerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ElevPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(ElevPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ElevPanelLayout.createSequentialGroup()
                                .addGap(0, 117, Short.MAX_VALUE)
                                .addComponent(Floor3)
                                .addGap(87, 87, 87)
                                .addComponent(Floor2)
                                .addGap(151, 151, 151)
                                .addComponent(CarPnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CallPanl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ElevPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ElevPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CallElevatorBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CallElevatorBtn1ActionPerformed
        Config.sendEvent(new ChooseFloorEvent(1, "CallElevatorBtn"));
    }//GEN-LAST:event_CallElevatorBtn1ActionPerformed

    private void doorStatusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doorStatusFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doorStatusFieldActionPerformed

    private void DoorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoorBtnActionPerformed
        // TODO add your handling code here:
        Config.sendEvent(new DoorEvent(true));
    }//GEN-LAST:event_DoorBtnActionPerformed

    private void StopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopBtnActionPerformed
        Config.sendEvent(new EmergencyStopEvent(true));

    }//GEN-LAST:event_StopBtnActionPerformed

    private void Floor2btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Floor2btnActionPerformed
        Config.sendEvent(new ChooseFloorEvent(2, "Floor"));         // TODO add your handling code here:
    }//GEN-LAST:event_Floor2btnActionPerformed

    private void CloseDoorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseDoorBtnActionPerformed
        // TODO add your handling code here:
        Config.sendEvent(new DoorEvent(false));
    }//GEN-LAST:event_CloseDoorBtnActionPerformed

    private void CallElevatorBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CallElevatorBtn2ActionPerformed
        Config.sendEvent(new ChooseFloorEvent(2, "CallElevatorBtn"));
    }//GEN-LAST:event_CallElevatorBtn2ActionPerformed

    private void CallElevatorBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CallElevatorBtn3ActionPerformed
        Config.sendEvent(new ChooseFloorEvent(3, "CallElevatorBtn"));
    }//GEN-LAST:event_CallElevatorBtn3ActionPerformed

    private void Floor1btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Floor1btnActionPerformed
        Config.sendEvent(new ChooseFloorEvent(1, "Floor"));
    }//GEN-LAST:event_Floor1btnActionPerformed

    private void Floor3btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Floor3btnActionPerformed
        Config.sendEvent(new ChooseFloorEvent(3, "Floor"));         // TODO add your handling code here:
    }//GEN-LAST:event_Floor3btnActionPerformed

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
            java.util.logging.Logger.getLogger(ElevatorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElevatorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElevatorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElevatorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ElevatorUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CallElevatorBtn1;
    private javax.swing.JButton CallElevatorBtn2;
    private javax.swing.JButton CallElevatorBtn3;
    private javax.swing.JPanel CallPanl;
    private javax.swing.JPanel CarPnel;
    private javax.swing.JButton CloseDoorBtn;
    private javax.swing.JButton DoorBtn;
    private javax.swing.JLabel DoorStatus;
    private javax.swing.JPanel ElevPanel;
    private javax.swing.JPanel ElevatorControllerPanel;
    private javax.swing.JLabel ElevatorPanel;
    private javax.swing.JLabel Floor1;
    private javax.swing.JLabel Floor1Label;
    private javax.swing.JButton Floor1btn;
    private javax.swing.JLabel Floor2;
    private javax.swing.JLabel Floor2Label;
    private javax.swing.JButton Floor2btn;
    private javax.swing.JLabel Floor3;
    private javax.swing.JLabel Floor3Label;
    private javax.swing.JButton Floor3btn;
    private javax.swing.JLabel Light;
    private javax.swing.JLabel LightOff;
    private javax.swing.JLabel LightOn;
    private javax.swing.JPanel LightPanel;
    private javax.swing.JButton StopBtn;
    private javax.swing.JTextField WeightInput;
    private javax.swing.JLabel WeightLabel;
    private javax.swing.JTextField doorStatusField;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public JButton getEmergencyStopBtn() {
        return StopBtn;
    }

    public JPanel getElevatorPanel() {
        return ElevatorControllerPanel; //To change body of generated methods, choose Tools | Templates.
    }

    public JPanel getElevPanel() {
        return ElevPanel; //To change body of generated methods, choose Tools | Templates.
    }

    public JTextField getDoorStatus() {
        return doorStatusField;
    }

    public JPanel getLightPanel() {
        return LightPanel;
    }

    public JButton getCallElevatorBtn1() {
        return CallElevatorBtn1;
    }

    public JButton getCallElevatorBtn2() {
        return CallElevatorBtn2;
    }

    public JButton getCallElevatorBtn3() {
        return CallElevatorBtn3;
    }

    public JPanel getCallPanl() {
        return CallPanl;
    }

    public JPanel getCarPnel() {
        return CarPnel;
    }

    public JButton getCloseDoorBtn() {
        return CloseDoorBtn;
    }

    public JButton getDoorBtn() {
        return DoorBtn;
    }

    public JPanel getElevatorControllerPanel() {
        return ElevatorControllerPanel;
    }

    public JLabel getFloor1() {
        return Floor1;
    }

    public JLabel getFloor1Label() {
        return Floor1Label;
    }

    public JButton getFloor1btn() {
        return Floor1btn;
    }

    public JLabel getFloor2() {
        return Floor2;
    }

    public JLabel getFloor2Label() {
        return Floor2Label;
    }

    public JButton getFloor2btn() {
        return Floor2btn;
    }

    public JLabel getFloor3() {
        return Floor3;
    }

    public JLabel getFloor3Label() {
        return Floor3Label;
    }

    public JButton getFloor3btn() {
        return Floor3btn;
    }

    public JLabel getLight() {
        return Light;
    }

    public JLabel getLightOff() {
        return LightOff;
    }

    public JLabel getLightOn() {
        return LightOn;
    }

    public JButton getStopBtn() {
        return StopBtn;
    }

    public JTextField getWeightInput() {
        return WeightInput;
    }

    public JLabel getWeightLabel() {
        return WeightLabel;
    }

    public JTextField getDoorStatusField() {
        return doorStatusField;
    }

}
