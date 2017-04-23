/**
 * Created by yuval_edelman on 3/25/2015.
 */
import javax.swing.JOptionPane;

     public class MainLife {
        public static void main(String []args){
            String row,col;
            int result=0;
            int rowNum,colNum;
            do{
                JOptionPane.showMessageDialog(null,"To start the life game press OK");
                row=JOptionPane.showInputDialog("Enter the number of row you like");
                rowNum=Integer.parseInt(row);
                col=JOptionPane.showInputDialog("Enter the number of column you like");
                colNum=Integer.parseInt(col);
                Life n=new Life(rowNum,colNum);
                JOptionPane.showMessageDialog(null,"To see the life matrix press OK");
                n.print();
                result = JOptionPane.showConfirmDialog( null, "to see the next life matrix press Yes, to start new life press Cancel, to exit press No","Message", JOptionPane.YES_NO_CANCEL_OPTION);
                while(result==0){
                    n.setNewLife();
                    n.printSecond();
                    result = JOptionPane.showConfirmDialog( null, "to see the next life matrix press Yes, to start new life press Cancel, to exit press No","Message", JOptionPane.YES_NO_CANCEL_OPTION);
                }
            }while(result!=1);
            JOptionPane.showMessageDialog(null,"thenks for playing");
        }
    }


