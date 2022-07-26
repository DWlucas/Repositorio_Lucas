package davila.lucas.uno.morintegracaocomjava.database_app.tabelas;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_aluno"
        , indices = {@Index(value = "id", unique = true)})
public class Aluno {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nome, celular, email, githubUsuario;



    //Construtor de cópia
    public Aluno(Aluno tblAluno){
        this.id            = tblAluno.getId();
        this.nome          = tblAluno.getNome();
        this.celular       = tblAluno.getCelular();
        this.email         = tblAluno.getEmail();
        this.githubUsuario = tblAluno.getGithubUsuario();

    }

    public int getId() { return id; }

    public void setId(int id) { id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { nome = nome; }

    public String getCelular() { return celular; }

    public void setCelular(String celular) { celular = celular; }

    public String getEmail() { return email; }

    public void setEmail(String email) { email = email; }

    public String getGithubUsuario() { return githubUsuario; }

    public void setGithubUsuario(String githubUsuario) { githubUsuario = githubUsuario; }
}