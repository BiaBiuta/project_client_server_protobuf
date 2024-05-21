package org.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SampleRepository implements ISampleRepository{
    private static final Logger logger= LogManager.getLogger();
    private JdbcUtils dbUtils;
    public SampleRepository(Properties props){
        logger.info("Initializing SampleRepository with properties: {}",props);
        dbUtils = new JdbcUtils(props);
    }
    @Override
    public Sample findOne(Integer integer) {
        logger.traceEntry();
        Connection con  = dbUtils.getConnection();
        Sample sample = null;
        try(PreparedStatement preparedStatement=con.prepareStatement("select * from samples where id_sample=?")) {
            preparedStatement.setInt(1, integer);
            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    int id = result.getInt("id_sample");
                    String name = result.getString("sample_categories");
                    String age = result.getString("age_category");
                    sample = new Sample(SampleCategory.fromString(name), AgeCategory.fromString(age));
                    sample.setId(id);
                    logger.trace("Found {} instances",sample);
                }
            }
        } catch (Exception e) {
            logger.error(e);
            System.out.println("Error DB " + e);
            logger.traceExit(sample);
            return sample;
        }
        logger.traceExit(sample);
        return sample;
    }

    public Sample findOneByCategoryAndAge(String category, String age_category) {
        logger.traceEntry();
        Connection con  = dbUtils.getConnection();
        Sample sample = null;
        try(PreparedStatement preparedStatement=con.prepareStatement("select * from samples where sample_categories=? and age_category=?")) {
            preparedStatement.setString(1,category );
            preparedStatement.setString(2,age_category );
            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    int id = result.getInt("id_sample");
                    String name = result.getString("sample_categories");
                    String age = result.getString("age_category");
                    sample = new Sample(SampleCategory.fromString(name), AgeCategory.fromString(age));
                    sample.setId(id);
                    logger.trace("Found {} instances",sample);
                }
            }
        } catch (Exception e) {
            logger.error(e);
            System.out.println("Error DB " + e);
            logger.traceExit(sample);
            return sample;
        }
        logger.traceExit(sample);
        return sample;
    }

    @Override
    public Sample updateSample(Sample sample) {
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement=con.prepareStatement("update samples set sample_categories=?,age_category=? where id_sample=?")){
            preparedStatement.setString(1,sample.getSampleCategory().toString());
            preparedStatement.setString(2,sample.getAgeCategory().toString());
            preparedStatement.setInt(3,sample.getId());
            int rowsAffected=preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                logger.trace("Updated sample {}",sample);
            } else {
                logger.error("Update sample failed");
            }
        }catch (Exception e){
            logger.error(e);
            System.out.println("Error DB " + e);
            logger.traceExit();
            return null;
        }
        logger.traceExit();
        return sample;
    }

    @Override
    public Sample deleteSample(Sample sample) {
        logger.traceEntry("deleting sample {}",sample);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement=con.prepareStatement("delete from samples where id_sample=?")){
            preparedStatement.setInt(1,sample.getId());
            int rowsAffected=preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                logger.trace("Deleted sample {}",sample);
            } else {
                logger.error("Delete sample failed");
            }
        }catch (Exception e){
            logger.error(e);
            System.out.println("Error DB " + e);
            logger.traceExit();
            return null;
        }
        logger.traceExit();
        return sample;
    }


    @Override
    public Iterable<Sample> findAll() {
        logger.traceEntry();
        Connection con = dbUtils.getConnection();
        List<Sample> samples= new ArrayList<>();
        try(PreparedStatement preparedStatement=con.prepareStatement("select * from samples")) {
            try (ResultSet result = preparedStatement.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id_sample");
                    String name = result.getString("sample_categories");
                    String age = result.getString("age_category");
                    Sample sample = new Sample(SampleCategory.fromString(name), AgeCategory.fromString(age));
                    sample.setId(id);
                    samples.add(sample);
                }
            }
        } catch (Exception e) {
            logger.error(e);
            System.out.println("Error DB " + e);
            logger.traceExit(samples);
            return samples;
        }
        logger.traceExit(samples);
        return samples;
    }

    @Override
    public Sample save(Sample entityForAdd) {
        logger.traceEntry("saving sample {}",entityForAdd);
        Connection con = dbUtils.getConnection();
        try(PreparedStatement preparedStatement=con.prepareStatement("insert into samples (sample_categories,age_category) values (?,?)")){
            preparedStatement.setString(1,entityForAdd.getSampleCategory().toString());
            preparedStatement.setString(2,entityForAdd.getAgeCategory().toString());
            int rowsAffected=preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                try (Statement statement = con.createStatement()) {
                    try (ResultSet resultSet = statement.executeQuery("SELECT last_insert_rowid()")) {
                        if (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            entityForAdd.setId(id);
                        } else {
                            logger.error("Nu s-au găsit chei generate pentru inserarea entității");
                        }
                    }
                }
            } else {
                logger.error("Inserarea entității a eșuat");
            }
            logger.trace("Saved sample {}",entityForAdd);
        }catch (Exception e){
            logger.error(e);
            System.out.println("Error DB " + e);
            logger.traceExit();
            return null;
        }
        logger.traceExit();
        return entityForAdd;
    }
}
