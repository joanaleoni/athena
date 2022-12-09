/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package View;

import Model.Domain.Aluno;
import Utils.DateFormat;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Karlos
 */
public class CadastraAluno extends javax.swing.JInternalFrame {

    private Aluno objaluno;
    public CadastraAluno() {
        initComponents();
        this.objaluno = new Aluno();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text_nomeAluno = new javax.swing.JLabel();
        c_nomeAluno = new javax.swing.JTextField();
        text_dataNascAluno = new javax.swing.JLabel();
        c_dataNascAluno = new javax.swing.JTextField();
        text_rgAluno = new javax.swing.JLabel();
        c_rgAluno = new javax.swing.JTextField();
        text_cpfAluno = new javax.swing.JLabel();
        c_faseAluno = new javax.swing.JTextField();
        botao_cancelarAluno = new javax.swing.JButton();
        botao_confirmarAluno = new javax.swing.JButton();
        titulo_cadAluno = new javax.swing.JLabel();
        text_faseAluno = new javax.swing.JLabel();
        c_cpfAluno1 = new javax.swing.JTextField();
        text_curso = new javax.swing.JLabel();
        c_curso = new javax.swing.JTextField();

        setBackground(new java.awt.Color(135, 192, 221));
        setMinimumSize(new java.awt.Dimension(549, 412));
        setPreferredSize(new java.awt.Dimension(549, 412));

        text_nomeAluno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_nomeAluno.setText("Nome:");

        c_nomeAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_nomeAlunoActionPerformed(evt);
            }
        });

        text_dataNascAluno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_dataNascAluno.setText("Nascimento:");

        c_dataNascAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_dataNascAlunoActionPerformed(evt);
            }
        });

        text_rgAluno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_rgAluno.setText("RG:");

        c_rgAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_rgAlunoActionPerformed(evt);
            }
        });

        text_cpfAluno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_cpfAluno.setText("CPF:");

        c_faseAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_faseAlunoActionPerformed(evt);
            }
        });

        botao_cancelarAluno.setBackground(new java.awt.Color(255, 102, 102));
        botao_cancelarAluno.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        botao_cancelarAluno.setForeground(new java.awt.Color(0, 0, 0));
        botao_cancelarAluno.setText("CANCELAR");
        botao_cancelarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cancelarAlunoActionPerformed(evt);
            }
        });

        botao_confirmarAluno.setBackground(new java.awt.Color(153, 255, 153));
        botao_confirmarAluno.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        botao_confirmarAluno.setForeground(new java.awt.Color(0, 0, 0));
        botao_confirmarAluno.setText("CONFIRMAR");
        botao_confirmarAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botao_confirmarAlunoMouseClicked(evt);
            }
        });
        botao_confirmarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_confirmarAlunoActionPerformed(evt);
            }
        });

        titulo_cadAluno.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titulo_cadAluno.setForeground(new java.awt.Color(0, 102, 102));
        titulo_cadAluno.setText(" Cadastro de Alunos");

        text_faseAluno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_faseAluno.setText("Fase:");

        c_cpfAluno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cpfAluno1ActionPerformed(evt);
            }
        });

        text_curso.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        text_curso.setText("Curso:");

        c_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_cursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(botao_cancelarAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botao_confirmarAluno))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_cpfAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_cpfAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_rgAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c_rgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_nomeAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c_nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_dataNascAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c_dataNascAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_faseAluno)
                                .addGap(18, 18, 18)
                                .addComponent(c_faseAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_curso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c_curso, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(titulo_cadAluno))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(titulo_cadAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_nomeAluno)
                    .addComponent(c_nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_dataNascAluno)
                    .addComponent(c_dataNascAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_rgAluno)
                    .addComponent(c_rgAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_cpfAluno)
                    .addComponent(c_cpfAluno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_curso)
                    .addComponent(c_curso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_faseAluno)
                    .addComponent(c_faseAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_cancelarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_confirmarAluno)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_nomeAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_nomeAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_nomeAlunoActionPerformed

    private void c_dataNascAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_dataNascAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_dataNascAlunoActionPerformed

    private void c_rgAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_rgAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_rgAlunoActionPerformed

    private void c_faseAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_faseAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_faseAlunoActionPerformed

    private void botao_confirmarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_confirmarAlunoActionPerformed
        try {
            //recebendo e validadno dadso da interface gráfica
//          
            String nome = "";
            LocalDate nascimento = null;
            String rg = "";
            String cpf = "";
            int fase = 0;
            String curso = "";

            if (this.c_nomeAluno.getText().length() < 2) {
                throw new Mensagens("Nome deve conter ao menos 2 caracteres");
            } else {
                nome = this.c_nomeAluno.getText();
            }

            if (this.c_dataNascAluno.getText().length() != 10) {
                throw new Mensagens("Data de nascimento deve conter 10 caracteres");
            } else {
                nascimento = DateFormat.converterDataSQL(this.c_dataNascAluno.getText());
            }

            if (this.c_rgAluno.getText().length() != 7) {
                throw new Mensagens("RG deve conter 7 caracteres");
            } else {
                rg = this.c_rgAluno.getText();
            }

            if (this.c_cpfAluno1.getText().length() != 11) {
                throw new Mensagens("CPF deve conter 11 caracteres");
            } else {
                cpf = this.c_cpfAluno1.getText();
            }

            if (Integer.parseInt(this.c_faseAluno.getText()) <= 0) {
                throw new Mensagens("Fase deve ser número e maior que zero");
            } else {
                fase = Integer.parseInt(this.c_faseAluno.getText());
            }
            if (this.c_curso.getText().length() < 2) {
                throw new Mensagens("Curso deve ter mais que 2 caracteres");
            } else {
                curso = this.c_curso.getText();
            }
            try {
                //envia os dados para cadastrar
                if (this.objaluno.InsertAlunoBD(fase, curso, nome, nascimento, rg, cpf)) {
                    JOptionPane.showMessageDialog(null, "Aluno Cadastrado com Sucesso");
                    
                    //limpa campos da interface
                    this.c_nomeAluno.setText("");
                    this.c_dataNascAluno.setText("");
                    this.c_rgAluno.setText("");
                    this.c_cpfAluno1.setText("");
                    this.c_curso.setText("");
                    this.c_faseAluno.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CadastraAluno.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(this.objaluno.getAlunos().toString());
        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número");
        }

    }//GEN-LAST:event_botao_confirmarAlunoActionPerformed

    private void botao_cancelarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cancelarAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botao_cancelarAlunoActionPerformed

    private void c_cpfAluno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cpfAluno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cpfAluno1ActionPerformed

    private void botao_confirmarAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botao_confirmarAlunoMouseClicked
        
    }//GEN-LAST:event_botao_confirmarAlunoMouseClicked

    private void c_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_cursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_cursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_cancelarAluno;
    private javax.swing.JButton botao_confirmarAluno;
    private javax.swing.JTextField c_cpfAluno1;
    private javax.swing.JTextField c_curso;
    private javax.swing.JTextField c_dataNascAluno;
    private javax.swing.JTextField c_faseAluno;
    private javax.swing.JTextField c_nomeAluno;
    private javax.swing.JTextField c_rgAluno;
    private javax.swing.JLabel text_cpfAluno;
    private javax.swing.JLabel text_curso;
    private javax.swing.JLabel text_dataNascAluno;
    private javax.swing.JLabel text_faseAluno;
    private javax.swing.JLabel text_nomeAluno;
    private javax.swing.JLabel text_rgAluno;
    private javax.swing.JLabel titulo_cadAluno;
    // End of variables declaration//GEN-END:variables
}
