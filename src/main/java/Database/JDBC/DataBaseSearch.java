package Database.JDBC;

import Database.Model.*;

import java.sql.SQLException;


public class DataBaseSearch {


    public static int IsHere(LibraryDatabaseModel e, Object a, String str) {

        if(a.getClass() == Note.class){
            Note is_here = null;
            try {

                is_here = e.getObjectModel(Note.class)
                        .getFirst("note = ?",
                                str);

            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            if (is_here == null){

                return 0;
            }else{

                return is_here.getId();

            }

        }

        if(a.getClass() == AcquisitionDate.class){
            AcquisitionDate is_here = null;
            try {
                is_here = e.getObjectModel(AcquisitionDate.class)
                        .getFirst("acquisition_date = ?",
                                str);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            if (is_here == null){

                return 0;
            }else{
                return is_here.getId_acquisition_date();
            }

        }

        if(a.getClass() == AcquisitionOrigine.class){
            AcquisitionOrigine is_here = null;
            try {
                is_here = e.getObjectModel(AcquisitionOrigine.class)
                        .getFirst("lieu_d_acquisition = ?",
                                str);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            if (is_here == null){

                return 0;
            }else{
                return is_here.getId_acquisition_origine();
            }

        }


        if(a.getClass() == Langue.class){
            Langue is_here = null;
            try {
                is_here = e.getObjectModel(Langue.class)
                        .getFirst("langue = ?",
                                str);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            if (is_here == null){

                return 0;
            }else{
                return is_here.getId();
            }

        }


        if(a.getClass() == Statut.class){
            Statut is_here = null;
            try {
                is_here = e.getObjectModel(Statut.class)
                        .getFirst("menu_statut = ?",
                                str);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            if (is_here == null){

                return 0;
            }else{
                return is_here.getId();
            }

        }


        if(a.getClass() == Support.class){
            Support is_here = null;
            try {
                is_here = e.getObjectModel(Support.class)
                        .getFirst("support_type = ?",
                                str);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            if (is_here == null){

                return 0;
            }else{
                return is_here.getId();
            }

        }

return 0;
    }



}
