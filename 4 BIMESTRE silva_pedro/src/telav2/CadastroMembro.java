/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telav2;

/**
 *
 * @author Aluno
 */
public class CadastroMembro extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastroMembro
     */
    public CadastroMembro() {
        initComponents();
        setSize(300,300);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        campoId1 = new telav2.MeuCampo();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        campoNome1 = new telav2.MeuCampo();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        campoDataNasc1 = new telav2.MeuCampoFormatado();
        jLabel18 = new javax.swing.JLabel();
        campoCpf1 = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        campoEndereco1 = new telav2.MeuCampo();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        campoTelefone1 = new telav2.MeuCampoFormatado();
        jLabel22 = new javax.swing.JLabel();
        campoCidade1 = new telav2.MeuCampoFormatado();
        jLabel23 = new javax.swing.JLabel();
        campoUsuario1 = new telav2.MeuCampo();
        jLabel24 = new javax.swing.JLabel();
        campoSenha1 = new telav2.MeuCampo();
        painelBotoes3 = new telav2.PainelBotoes();

        setClosable(true);

        jInternalFrame1.setVisible(true);

        jPanel2.setEnabled(false);
        jPanel2.setLayout(null);

        jLabel13.setText("CADASTRO DE MEMBROS");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(279, 26, 147, 14);

        campoId1.setEnabled(false);
        jPanel2.add(campoId1);
        campoId1.setBounds(133, 78, 69, 20);

        jLabel14.setText("Id:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(101, 81, 14, 14);

        jLabel15.setText("Nome:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(229, 81, 31, 14);

        campoNome1.setEnabled(false);
        jPanel2.add(campoNome1);
        campoNome1.setBounds(270, 78, 325, 20);

        jLabel16.setText("Sexo:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(101, 116, 28, 14);

        jLabel17.setText("Data de Nascimento:");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(229, 116, 100, 14);

        campoDataNasc1.setEnabled(false);
        jPanel2.add(campoDataNasc1);
        campoDataNasc1.setBounds(339, 116, 160, 20);

        jLabel18.setText("CPF:");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(101, 157, 23, 14);

        campoCpf1.setEnabled(false);
        campoCpf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCpfActionPerformed(evt);
            }
        });
        jPanel2.add(campoCpf1);
        campoCpf1.setBounds(134, 154, 216, 20);

        jLabel19.setText("Endereço:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(101, 195, 49, 14);

        campoEndereco1.setEnabled(false);
        jPanel2.add(campoEndereco1);
        campoEndereco1.setBounds(160, 192, 243, 20);

        jLabel20.setText("Cidade:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(101, 233, 37, 14);

        jLabel21.setText("Telefone:");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(301, 233, 46, 14);

        campoTelefone1.setEnabled(false);
        jPanel2.add(campoTelefone1);
        campoTelefone1.setBounds(351, 230, 189, 20);

        jLabel22.setText("Cidade:");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(10, 271, 37, 14);

        campoCidade1.setEnabled(false);
        jPanel2.add(campoCidade1);
        campoCidade1.setBounds(57, 268, 219, 20);

        jLabel23.setText("Usuário:");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(10, 309, 40, 14);

        campoUsuario1.setEnabled(false);
        jPanel2.add(campoUsuario1);
        campoUsuario1.setBounds(60, 306, 216, 20);

        jLabel24.setText("Senha:");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(10, 347, 34, 14);

        campoSenha1.setEnabled(false);
        jPanel2.add(campoSenha1);
        campoSenha1.setBounds(62, 344, 214, 20);
        jPanel2.add(painelBotoes3);
        painelBotoes3.setBounds(111, 382, 474, 74);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCpfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private telav2.MeuCampoFormatado campoCidade1;
    private javax.swing.JFormattedTextField campoCpf1;
    private telav2.MeuCampoFormatado campoDataNasc1;
    private telav2.MeuCampo campoEndereco1;
    private telav2.MeuCampo campoId1;
    private telav2.MeuCampo campoNome1;
    private telav2.MeuCampo campoSenha1;
    private telav2.MeuCampoFormatado campoTelefone1;
    private telav2.MeuCampo campoUsuario1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel2;
    private telav2.PainelBotoes painelBotoes3;
    // End of variables declaration//GEN-END:variables
}
