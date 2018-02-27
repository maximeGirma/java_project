package DataBaseModel;

public class SandBox {


      /*try {
            List<Oeuvre> genre_list = database.getObjectModel(Oeuvre.class).getAll("id = ?", 1);
            System.out.println(genre_list.get(0).getGenres());
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



       /*try {
            Hashtable results = new Hashtable();

            List<Genre> genre_list = database.getObjectModel(Genre.class).getAll("label = ?", "Drame");
            for (Genre genres : genre_list) {
                System.out.println(genres);
                for (Oeuvre oeuvre : genres.getOeuvres()) {
                    results.put(oeuvre.getId(), oeuvre.getTitre());
                    System.out.println(oeuvre.getId() +": "+ oeuvre.getTitre());
                }
            }

            Enumeration e = results.elements();

            while(e.hasMoreElements())
                System.out.println(e.nextElement());

        } catch (SQLException e) {
            e.printStackTrace();
        }*/



       /*try {
            Hashtable results = new Hashtable();

            List<Category> categoryList = database.getObjectModel(Category.class).getAll("name_category = ?", "FILM");
            for (Category category : categoryList) {
                System.out.println(category);
                for (Oeuvre oeuvre : category.getOeuvres()) {
                    results.put(oeuvre.getId(), oeuvre.getTitre());
                    System.out.println(oeuvre.getId() +": "+ oeuvre.getTitre());
                }
            }

            Enumeration e = results.elements();

            while(e.hasMoreElements())
                System.out.println(e.nextElement());

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        /*Film film2 = new Film();
        film2.setTitre("Shrek");



         /*    database.getObjectModel(Oeuvre.class).insert(film2);
            database.getObjectModel(Oeuvre.class).insert(music1);*/

        /*try {
            List<Oeuvre> oeuvres = database.getObjectModel(Oeuvre.class).getAll();

            for (Oeuvre oeuvre : oeuvres) {
                oeuvre.getCategoryName(database);
                System.out.println(oeuvre.category_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



        /*SearchDisplay search = new SearchDisplay();
        search.getTitleByCategory(1, database);

        HashMap<Long, Oeuvre> results = search.getOeuvreList();

        for (Map.Entry<Long, Oeuvre> entry : results.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue().toString());
        }*/



        /*try {
            List<Note> noteList = database.getObjectModel(Note.class).getAll("Note = ?", "5");
            for (Note note : noteList) {
                System.out.println(note);
                for (Oeuvre oeuvre : note.getOeuvres()) {
                    System.out.println(oeuvre);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

}
