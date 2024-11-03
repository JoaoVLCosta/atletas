package br.edu.fateczl.atletas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment;

    private final HashMap<Integer, String> MAPA_CHAVE = new HashMap<>(Map.ofEntries(
            Map.entry(R.id.item_s, "AS"),
            Map.entry(R.id.item_j, "AJ"),
            Map.entry(R.id.item_o, "AO")
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            carregaFragment(bundle);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        alternar(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void alternar(int itemID){
        Bundle bundle = new Bundle();
        bundle.putString("tipoAtleta", MAPA_CHAVE.get(itemID));
        Intent i = new Intent(this, MainActivity.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }

    private void carregaFragment(Bundle bundle) {
        HashMap<String, Fragment> mapaFrag = new HashMap<>();
        mapaFrag.put("AS", new Senior());
        mapaFrag.put("AJ", new Juvenil());
        mapaFrag.put("AO", new Outro());

        fragment = mapaFrag.get(bundle.getString("tipoAtleta"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }

}