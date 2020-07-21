private void updateVelocity(Particle p){
    
    double w = 0.5;
    
    double o1 = 0.5;
    double b1 = 0.5;
    
    double o2 = 0.5;
    double b2 = 0.5;
    
    double[] newV = new double[p.pVelocity.length];
    
    for(int i=0; i<newV.length; i++){      
      newV[i] = w*p.pVelocity[i] + (o1*b1*(p.pBest[i]-p.xSolution[i])) + (o2*b2*(gBest[i] - p.xSolution[i]));       
    }
    
    p.pVelocity = newV;
    
  }
  
  private void updateSolution(Particle p){
    
    for(int i=0; i<p.xSolution.length; i++){
      p.xSolution[i] = p.xSolution[i] + p.pVelocity[i] > p.xSolution.length ? p.xSolution.length : p.xSolution[i] + p.pVelocity[i];
    }
    
  }
  
  public int[] decodeOptimalSolution(){
    
    System.out.println("gFitnessValue=" + gFitnessValue);
    System.out.println("gBest="+Arrays.toString(gBest));    
    
    Map<Double, List<Integer>> indicies = new HashMap<>();
    
    for(int i=0; i<gBest.length ; i++){
      if(indicies.get(gBest[i])== null)
        indicies.put(gBest[i], new ArrayList<Integer>());
      
      indicies.get(gBest[i]).add(i);
    }
    
    Arrays.sort(gBest);
    
    int[] optimalRoute = new int[gBest.length];
    
    for(int i=0; i<optimalRoute.length;i++){
      if(indicies.get(gBest[i]).size() > 1){
        // find the lowest velocity and add that first        
        int ii = i;
        for(int k=0; k<indicies.get(gBest[ii]).size(); k++){          
          optimalRoute[i] = indicies.get(gBest[ii]).get(k) + 1;
          i++;
        }        
        
      }else      
       optimalRoute[i] = indicies.get(gBest[i]).get(0) + 1;
    }
    
    return optimalRoute;
  }
  
  public void printSwarmDetails(){
    
    
    System.out.println("No of Particles : " + particles.length);
    
    
    System.out.println("Particle Details : ");
    for(Particle p: particles)
      System.out.println(p);
    
    System.out.println("Global   [gBest="+Arrays.toString(gBest)+", gFitnessValue=" + gFitnessValue+"]");
        
  }
  
  public void printIterationResults(int t, Map<String, Map<Double, Double>> particleProgress){
    System.out.print(t+ " \t\t");
    int pNo = 1;
    for(Particle p: particles){
      if(particleProgress.get("p"+pNo) == null)
        particleProgress.put("p"+pNo, new HashMap<Double, Double>());
      
      particleProgress.get("p"+pNo).put((double) t, p.pBestValue);      
      System.out.print(p.xFitnessValue + "\t" + p.pBestValue + "\t\t");
      pNo++;
    }
    System.out.println(gFitnessValue);
  }

  public double[] getgBest() {
    return gBest;
  }

  public void setgBest(double[] gBest) {
    this.gBest = gBest;
  }

  public Particle[] getParticles() {
    return particles;
  }

  public void setParticles(Particle[] particles) {
    this.particles = particles;
  }

  public double getgFitnessValue() {
    return gFitnessValue;
  }

  public void setgFitnessValue(double gFitnessValue) {
    this.gFitnessValue = gFitnessValue;
  }