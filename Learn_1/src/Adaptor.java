
public class Adaptor
{
    public static void main(String ...args)
    {
      PlayerImp playerImp = new PlayerImp();
      playerImp.play("mp3");
      playerImp.play("mp4");
      playerImp.play("wmv");
    }
}

interface MediaPlayer 
{
  void play(String typr);
}

interface VideoPlayer
{
  void playMp4();
  void playWmv();
}

class Mp4VideoPlayerImp implements VideoPlayer
{

  @Override
  public void playMp4()
  {
    System.out.println("Playing MP4");
    
  }

  @Override
  public void playWmv()
  {
    // TODO Auto-generated method stub
    
  }
  
}

class WmvVideoMediaPlayerImp implements VideoPlayer
{

  @Override
  public void playMp4()
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void playWmv()
  {
    System.out.println("Playing WMV");
    
  }
  
}

class MediaAdapter implements MediaPlayer
{
  VideoPlayer videoPlayer;
  
  MediaAdapter(String type){
    if(type.equals("mp4"))
    {
      videoPlayer = new Mp4VideoPlayerImp();
    }
    else
    {
      videoPlayer = new WmvVideoMediaPlayerImp();
    }
  }
  @Override
  public void play(String typr)
  {
    if("mp4".equals(typr))
    {
      videoPlayer.playMp4();
    }
    else
    {
      videoPlayer.playWmv();
    }
    
  }
  
}

class PlayerImp implements MediaPlayer
{
  MediaAdapter mediaAdapter;
  @Override
  public void play(String typr)
  {
    if("mp3".equals(typr))
    {
      System.out.println("Playing mp3");
    }
    else
    if("mp4".equals(typr)|| "wmv".equals(typr))
    {
      mediaAdapter = new MediaAdapter(typr);
      mediaAdapter.play(typr);
    }
    
  }
  
}
