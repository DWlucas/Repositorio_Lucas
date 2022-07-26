package davila.lucas.uno.morintegracaocomjava.database_app.interfaces_dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.List;

import davila.lucas.uno.morintegracaocomjava.database_app.tabelas.Aluno;
import davila.lucas.uno.morintegracaocomjava.database_app.tabelas.AlunoProva;

public interface ICRUDAlunoProvaDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlunoProva(AlunoProva tbl_aluno_prova);

    //public void insertAlunoProva (AlunoProva tbl_aluno_prova);

    @Query("SELECT * FROM tbl_aluno_prova where aluno_id = :id")
    AlunoProva getEspecificaAlunoProvaById(int id);

    // public String getEspecificAlunoProvaByID(AlunoProva id);

    //List<AlunoProva>getAllAlunoProva();

    //void updateAlunoProva (AlunoProva tbl_aluno_prova);

    //void deleteAlunoProva(AlunoProva tbl_aluno_prova);

    void deleteAlunoProvaByID(AlunoProva id);

    //void deleteAllAlunoProva ();

    @Transaction
    @Update(entity = AlunoProva.class, onConflict = OnConflictStrategy.REPLACE)
    void updateAlunoProva(AlunoProva alunoProvaTable);

    //O CASCADE deverá funcionar aqui p/ a tabela: AlunoProva
    @Transaction
    @Delete(entity = AlunoProva.class)
    void deleteAlunoProva(AlunoProva alunoProvaTable);

    @Transaction
    @Query("DELETE FROM tbl_aluno_prova WHERE aluno_id = :id")
    void deleteAlunoProvaByID(int id);

    @Transaction
    @Query("DELETE FROM tbl_aluno WHERE id > 0")
    void deleteAllAlunoProva();
}
