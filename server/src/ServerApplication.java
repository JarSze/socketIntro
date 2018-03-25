import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jszeligowski on 2018-03-24.
 */
public class ServerApplication
{
    private static final int PORT = 5000;

    public static void main( String[] args )
    {
        try
        {
            BufferedReader reader;
            PrintWriter writter;

            ServerSocket serverSocket = new ServerSocket( PORT );

            while( true )
            {
                Socket client = serverSocket.accept();
                System.out.println( "Client connected" );

                reader = new BufferedReader( new InputStreamReader( client.getInputStream() ) );
                writter = new PrintWriter( client.getOutputStream() );

                String message = reader.readLine();
                System.out.println( "Received message: " + message );
                writter.write( "this is message from server" );
                writter.flush();
                client.close();
                //serverSocket.close();
            }
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }
}
