package GraphicalUtilisateurInterface.DisplayController;

public class SearchDisplay {

    public static void getTitleByCategory(int category_type){
        switch (category_type){
            case 1:
                System.out.println("flims!");;
                break;
            case 2:
                System.out.println("livres!");;
                break;
            case 3:
                System.out.println("musqiue!");;
                break;
            case 4:
                System.out.println("jxvideos!");;
                break;
            default:
                System.out.println("houston, we've got a problem");
        }
    }
}
