package davila.lucas.uno.morintegracaocomjava.database_app.tabelas;


import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_aluno"
        , indices = {@Index(value = "id", unique = true)})
public class Resposta {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int pergunta_id;
    private String resposta;

    public Resposta(Resposta tblResposta){
        this.id          = tblResposta.getId();
        this.resposta    = tblResposta.getResposta();
        this.pergunta_id = tblResposta.getPergunta_id();
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getPergunta_id() { return pergunta_id; }

    public void setPergunta_id(int pergunta_id) { this.pergunta_id = pergunta_id; }

    public String getResposta() { return resposta; }

    public void setResposta(String resposta) { this.resposta = resposta; }
}