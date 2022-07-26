package davila.lucas.uno.morintegracaocomjava.database_app.tabelas;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import static androidx.room.ForeignKey.CASCADE;


@Entity(tableName = "tbl_pergunta"
        , indices = {@Index(value = {"prova_id"}) , @Index(value = {"resposta_id"}) , @Index(value = {"id"})}
        , foreignKeys = {@ForeignKey(entity = Prova.class , parentColumns = "id" ,
        childColumns = "prova_id" , onUpdate = CASCADE , onDelete = CASCADE)
        , @ForeignKey(entity = Prova.class , parentColumns = "id" ,
        childColumns = "resposta_id" , onUpdate = CASCADE , onDelete = CASCADE)})
public class Pergunta {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int prova_id;
    private String pergunta;

    public Pergunta(){}

    //Construtor de cópia
    public Pergunta(Pergunta tblPergunta){
        this.id       = tblPergunta.getId();
        this.prova_id = tblPergunta.getProva_id();
        this.pergunta = tblPergunta.getPergunta();

    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getProva_id() { return prova_id; }

    public void setProva_id(int prova_id) { this.prova_id = prova_id; }

    public String getPergunta() { return pergunta; }

    public void setPergunta(String pergunta) { this.pergunta = pergunta; }
}