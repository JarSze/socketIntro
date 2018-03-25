import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by jszeligowski on 2018-03-25.
 */
public class ClientApplication
{
    public static void main( String[] args )
    {
        Socket clientSocket = new Socket();
        try
        {
            clientSocket.connect( new InetSocketAddress( "localhost", 5000 ) );

            Scanner reader = new Scanner( clientSocket.getInputStream() );
            PrintWriter writer = new PrintWriter( (clientSocket.getOutputStream()) );

            writer.write( "Writer write hello world!\n" );
            writer.flush();

            String response = reader.next();
            System.out.println( "Server responded with message: " + response );

        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }
}
