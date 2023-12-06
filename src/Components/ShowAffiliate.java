package Components;

import Data.DataStructures.List;
import Data.Models.Affiliate;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class ShowAffiliate extends JInternalFrame{
    private JPanel panel1;
    private JLabel titulo;
    private JTable affiliatesTable;

    public ShowAffiliate(Landing landing){

        this.setSize(800, 600);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Consultar Afiliados");
        this.setResizable(true);
        this.setIconifiable(true);
        this.setClosable(true);

        List<Affiliate> affiliates = landing.Affiliates.show();
        AffiliateTableModel model = new AffiliateTableModel(affiliates);

        affiliatesTable.setModel(model);


        this.setVisible(true);
    }

    private static class AffiliateTableModel extends AbstractTableModel{

        private final String[] columns = {"Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Tipo", "Id Usuario"};
        private List<Affiliate> Affiliates;

        private AffiliateTableModel(List<Affiliate> affiliates){
            this.Affiliates = affiliates;
        }
        @Override
        public int getRowCount() {
            return Affiliates.Count;
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {

            Affiliate affiliate = new Affiliate();

            try{
                affiliate = Affiliates.getItemAtIndex(rowIndex);
            }
            catch (Exception ex){

            }

            return switch (columnIndex){
               case 0 -> affiliate.getId();
               case 1 -> affiliate.getName();
               case 2 -> affiliate.getFathersLastName();
               case 3 -> affiliate.getMothersLastName();
               case 4 -> affiliate.getAge();
               case 5 -> affiliate.getType();
               case 6 -> affiliate.getUserId();
                default -> "-";
            };
        }

        @Override
        public String getColumnName (int column){
            return columns[column];
        }

        @Override
        public Class<?> getColumnClass (int columnIndex){
            if (getValueAt(0, columnIndex)!= null){
                return getValueAt(0, columnIndex).getClass();
            }
            else {
                return  Object.class;
            }
        }
    }

}
