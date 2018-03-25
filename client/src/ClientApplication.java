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
        System.out.println( "App started with params like: " );
        for( String arg : args )
        {
            System.out.println( arg );
        }

        //String start_args = args[ 0 ];

        Socket clientSocket = new Socket();
        Scanner scanner = new Scanner( System.in );
        try
        {
            clientSocket.connect( new InetSocketAddress( "localhost", Integer.parseInt( args[0] ) ) );

            BufferedReader reader =
                new BufferedReader( new InputStreamReader( clientSocket.getInputStream() ) );
            PrintWriter writer = new PrintWriter( (clientSocket.getOutputStream()) );

            System.out.println( "Enter message to server: " );
            String message = scanner.nextLine();

            writer.write( message + "\n" );
            writer.flush();

            String response = reader.readLine();
            System.out.println( "Server responded with message: " + response );
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }
}
