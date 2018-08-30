package br.com.marcelomonier.listacustomizada;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Lista extends AppCompatActivity {

    //Array de nomes
    String [] nomes = {"João", "José", "Jacó", "Davi", "Moises", "Jessé", "Marcelo",
            "Matheus", "Paulo", "Bartolomeu"};

    //Array de profissões
    String [] profissoes = {"Pedreiro", "Marceneiro", "Padeiro", "Professor", "Cobrador",
            "Motorista", "Taxista", "Engenheiro", "Advogado", "Médico"};

    //Array de imagens - É inteiro pq ele está referenciando o local da imagem
    int [] images = {R.drawable.appicon, R.drawable.appicon, R.drawable.appicon,
            R.drawable.appicon, R.drawable.appicon, R.drawable.appicon,
            R.drawable.appicon, R.drawable.appicon, R.drawable.appicon, R.drawable.appicon};

    //Objeto do ListView
    ListView list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //Referenciando a o ojeto a lista do XML
        list = (ListView) findViewById(R.id.list_custom);

       //Instância da classe que nós criamos - Lista customizada (É uma lista que não está nos modelos)
        MyAdapter myAdapter = new MyAdapter(Lista.this, nomes, profissoes, images);
        list.setAdapter(myAdapter);








    }
}

//Classe para criar uma lista customizada
class MyAdapter extends ArrayAdapter{

    //Declaração dos obejtos pertencentes a cada linha da lista
    int[] imageArray;
    String[] nomesArray;
    String[] profissoesArray;



    //Construtor para incluir os elementos da linha
    public MyAdapter(@NonNull Context context, String[] nomes1, String[] profissoes1, int[] img1) {
        super(context, R.layout.example_customview_row, R.id.nomes_xml, nomes1);
        this.imageArray = img1;
        this.nomesArray = nomes1;
        this.profissoesArray = profissoes1;
    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Referenciando o layout customizado que nós criamos (o parent é o parametro do método que foi gerado automaticamente)
        View row = layoutInflater.inflate(R.layout.example_customview_row, parent, false);

        //Referenciando a o ojeto a imagem do XML
        ImageView myImage = (ImageView) row.findViewById(R.id.logo);

        //Referenciando a o ojeto aos TextView do XML
        TextView myName = (TextView) row.findViewById(R.id.nomes_xml);
        TextView myProfissao = (TextView) row.findViewById(R.id.profissao_xml);



        //Fornecendo o elemento de um array especificando sua posição (O position é a variável que vai servir de contador)
        myImage.setImageResource(imageArray[position]);
        myName.setText(nomesArray[position]);
        myProfissao.setText(profissoesArray[position]);


        //Retorna a linha customizada
        return row;
    }
}
