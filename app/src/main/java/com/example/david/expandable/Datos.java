package com.example.david.expandable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Datos {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> dam1 = new ArrayList<String>();
        List<String> dam2 = new ArrayList<String>();
        List<String> daw1 = new ArrayList<String>();
        List<String> daw2 = new ArrayList<String>();

        ArrayList<Alumno> arrayList;
        arrayList = MainActivity.bd.consultarAlumnos();
        for(int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i).getGrupo().equals("1DAM")){
                dam1.add(arrayList.get(i).getNombre());
            }else if (arrayList.get(i).getGrupo().equals("2DAM")){
                dam2.add(arrayList.get(i).getNombre());
            }else if(arrayList.get(i).getGrupo().equals("1DAW")){
                daw1.add(arrayList.get(i).getNombre());
            }else if(arrayList.get(i).getGrupo().equals("2DAW")){
                daw2.add(arrayList.get(i).getNombre());
            }
        }

        expandableListDetail.put("1º DAM", dam1);
        expandableListDetail.put("2º DAM", dam2);
        expandableListDetail.put("1º DAW", daw1);
        expandableListDetail.put("2º DAW", daw2);
        return expandableListDetail;
    }
}
