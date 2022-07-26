package davila.lucas.uno.morintegracaocomjava.database_app.tabelas;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "tbl_aluno_prova"
        , primaryKeys = {"aluno_id", "prova_id"}
        , indices = {@Index(value = {"aluno_id"}),@Index(value = {"prova_id"})}
        , foreignKeys = {@ForeignKey(entity = Aluno.class, parentColumns = "id",
            childColumns = "Aluno", onUpdate = CASCADE, onDelete = CASCADE)
                ,@ForeignKey(entity = Prova.class, parentColumns = "id",
                    childColumns = "prova_id", onUpdate = CASCADE, onDelete = CASCADE)})
public class AlunoProva {
    private int aluno_id;
    private int prova_id;

    public AlunoProva() {}

    //Construtor de cópia
    public AlunoProva(AlunoProva tblAlunoProva){
        this.aluno_id = tblAlunoProva.getAluno_id();
        this.prova_id = tblAlunoProva.getProva_id();
    }

    public int getAluno_id() { return aluno_id; }

    public void setAluno_id(int aluno_id) { this.aluno_id = aluno_id; }

    public int getProva_id() { return prova_id; }

    public void setProva_id(int prova_id) { this.prova_id = prova_id; }

}