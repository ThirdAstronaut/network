package com.example.demo.service.impl;


import com.example.demo.service.PredictionService;

public class PredictionServiceImpl implements PredictionService {
    @Override
    public String predict(String imageUrl) {
        return "";
    }

    /*@Autowired
    private ZooModel xrayModel;

    public String diagnose(String imageUrl) {
        try (Predictor<BufferedImage, Classifications> predictor = xrayModel.newPredictor()) {
            Classifications result = predictor.predict(BufferedImageUtils.fromUrl(imageUrl));
            return "Diagnose: "
                    + result.best().getClassName()
                    + " , probability: "
                    + result.best().getProbability();
        } catch (Exception e) {
            throw new RuntimeException("Failed to diagnose", e);
        }
    }
        */
}
