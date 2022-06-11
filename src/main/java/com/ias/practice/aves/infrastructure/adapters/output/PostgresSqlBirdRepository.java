package com.ias.practice.aves.infrastructure.adapters.output;

import com.ias.practice.aves.application.domain.Bird;
import com.ias.practice.aves.application.domain.valueObjs.IdBird;
import com.ias.practice.aves.application.ports.output.BirdRepository;
import com.ias.practice.aves.infrastructure.logSystem.Log;
import com.ias.practice.aves.infrastructure.models.BirdDAO;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgresSqlBirdRepository implements BirdRepository {

    private final DataSource dataSource;

    public PostgresSqlBirdRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Bird bird) {
        String sql = "INSERT INTO birds (common_name, scientific_name, zone_name, confirmed_quantity) values (?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, bird.getCommonNameBird().getValue());
            preparedStatement.setString(2, bird.getScientificNameBird().getValue());
            preparedStatement.setString(3, bird.getZoneNameBird().getValue());
            preparedStatement.setInt(4, bird.getConfirmedQuantityBird().getValue());


            preparedStatement.execute();

        } catch (SQLException exception) {
            System.out.println("Errror DB....: "  + exception.getMessage());
            throw new RuntimeException("Error queryng database", exception);
        }
    }

    @Override
    public Optional<Bird> get(IdBird idBird) {
        String sql = "Select * From birds Where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, idBird.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                BirdDAO birdDAO= BirdDAO.fromResultSet(resultSet);
                // logic ---
                Bird bird = BirdDAO.toDomain();
                return Optional.of(bird);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {

            throw new RuntimeException("Error queryn database", exception);
        }

    }

    @Override
    public void update(Bird bird) {
        String sql = "Update birds Set common_name = ?, scientific_name = ?, zone_name = ?, confirmed_quantity = ? Where id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, bird.getCommonNameBird().getValue());
            preparedStatement.setString(2, bird.getScientificNameBird().getValue());
            preparedStatement.setString(3, bird.getZoneNameBird().getValue());
            preparedStatement.setInt(4, bird.getConfirmedQuantityBird().getValue());
            preparedStatement.setLong(5, bird.getIdBird().getValue());

            preparedStatement.execute();

        }catch (SQLException exception) {
            Log log = new Log(exception.getMessage(), "Error queryn database");
            log.logger();
            throw new RuntimeException("Error queryn database", exception);
        }
    }

    @Override
    public Boolean delete(IdBird idBird) {
        String sql = "Delete from birds Where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, idBird.getValue());

            Boolean result = preparedStatement.execute();

            return result;

        } catch (SQLException exception) {
            Log log = new Log(exception.getMessage(), "Error queryn database");
            throw  new RuntimeException("Error queryng database", exception);
        }
    }

}
