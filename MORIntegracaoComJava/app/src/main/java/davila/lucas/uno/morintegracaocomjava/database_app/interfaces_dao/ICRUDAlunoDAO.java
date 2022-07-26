package davila.lucas.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.List;

import davila.lucas.uno.morintegracaocomjava.database_app.tabelas.Aluno;

public interface ICRUDAlunoDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAluno(Aluno tbl_aluno);

    //public void insertAluno (Aluno tbl_aluno);

    @Query("SELECT * FROM tbl_aluno where id = :id")
    Aluno getEspecificaAlunoById(int id);

    //public String getEspecificAlunoByID(Aluno id);

    List<Aluno>getAllAlunos();

    //void updateAlunos (Aluno tbl_aluno);

    //void deleteAluno(Aluno tbl_aluno);

    //void deleteAlunoByID(Aluno id);

    //void deleteAllAlunos ();

    @Transaction
    @Update(entity = Aluno.class, onConflict = OnConflictStrategy.REPLACE)
    void updateAlunos(Aluno alunoTable);

    //O CASCADE deverá funcionar aqui p/ a tabela: AlunoProva
    @Transaction
    @Delete(entity = Aluno.class)
    void deleteAluno(Aluno alunoTable);

    @Transaction
    @Query("DELETE FROM tbl_aluno WHERE id = :id")
    void deleteAlunoByID(int id);

    @Transaction
    @Query("DELETE FROM tbl_aluno WHERE id > 0")
    void deleteAllAlunos();
}
