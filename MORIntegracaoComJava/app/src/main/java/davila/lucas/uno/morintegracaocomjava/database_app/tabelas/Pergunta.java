package davila.lucas.uno.morintegracaocomjava.database_app.tabelas;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_pergunta"
        , indices = {@Index(value = "id", unique = true)})
public class Pergunta {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int prova_id;
    private String pergunta;

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