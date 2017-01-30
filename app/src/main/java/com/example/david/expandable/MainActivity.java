package com.example.david.expandable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    protected static BDAlumnos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = new BDAlumnos(this);
        rellenaBD();

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = Datos.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new Adaptador(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " Lista expandida.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " Lista contraida.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });

    }

    protected void rellenaBD(){
        if(bd.consultarAlumnos().size() < 1){
            bd.insertarAlumno(bd.nuevaID(), "David", "2DAM");
            bd.insertarAlumno(bd.nuevaID(), "Natalia", "2DAM");
            bd.insertarAlumno(bd.nuevaID(), "VAlentín", "2DAM");
            bd.insertarAlumno(bd.nuevaID(), "Adolfo", "2DAM");
            bd.insertarAlumno(bd.nuevaID(), "Iñigo", "1DAM");
            bd.insertarAlumno(bd.nuevaID(), "Toni", "1DAM");
            bd.insertarAlumno(bd.nuevaID(), "Kike", "1DAM");
            bd.insertarAlumno(bd.nuevaID(), "Angel", "1DAM");
            bd.insertarAlumno(bd.nuevaID(), "Pedro", "2DAW");
            bd.insertarAlumno(bd.nuevaID(), "Pablo", "2DAW");
            bd.insertarAlumno(bd.nuevaID(), "Juan", "2DAW");
            bd.insertarAlumno(bd.nuevaID(), "Ines", "2DAW");
            bd.insertarAlumno(bd.nuevaID(), "Juanma", "1DAW");
            bd.insertarAlumno(bd.nuevaID(), "Javier", "1DAW");
            bd.insertarAlumno(bd.nuevaID(), "Lucía", "1DAW");
            bd.insertarAlumno(bd.nuevaID(), "Marta", "1DAW");
        }
    }
}
