package week11;

public class Sound {
    private int[] samples;
    
    public Sound(int[] samplesIn){
        samples = samplesIn;
    }

    public int limitAmplitude(int limit){
        int changed = 0;
        for (int i = 0; i < samples.length; i++){
            if (samples[i] > limit){
                samples[i] = limit;
                changed++;
            } else if (samples[i] < -limit){
                samples[i] = -limit;
                changed++;
            } 
        }

        return changed;
    }

    public void trimSilenceFromBeginning(){
        int startIndex = 0;
        for (int i = 0; i < samples.length; i++){
            if (samples[i] != 0){
                startIndex = i;
                break;
            }
        }

        int[] newSamples = new int[samples.length - startIndex];

        for (int i = 0; i < newSamples.length; i++){
            newSamples[i] = samples[i + startIndex];
        }

        samples = newSamples;
    }
}
