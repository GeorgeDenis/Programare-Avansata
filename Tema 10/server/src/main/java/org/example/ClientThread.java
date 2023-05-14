package org.example;

import org.example.model.Game;
import org.example.model.Player;
import org.example.model.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private GameServer gameServer;
    private Socket socket = null;
    private Player player;
    private Game game;


    public ClientThread(GameServer gameServer, Socket socket){
        this.gameServer = gameServer;
        this.socket = socket;
    }

    /**
     * Metoda verifica daca comanda introdusa e stop
     * @param out
     * @param request
     * @return
     */
    public boolean checkStop(PrintWriter out,String request){
        if(request.equals("stop")){
            String response = "Server stopped";
            out.println(response);
            out.flush();
            gameServer.stopServer();
            return true;
        }
        String response = "Server received the request: " + request;
        out.println(response);
        out.flush();
        return false;
    }
    @Override
    public void run () {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String request = in.readLine();
            boolean stopped = false;
            while(request != null){
                stopped = checkStop(out,request);
                if(stopped){
                    break;
                }

                Command command = new Command(request, gameServer, this);
                String message = command.executeCommand();
                System.out.println(message);
                String boardString = this.getGame().boardToString();
                out.println(message + "\n" + boardString + "\n<END>");
                out.flush();
                request = in.readLine();
                System.out.println("request:" + request);
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) { System.err.println(e); }
        }
    }

    public GameServer getGameServer() {
        return gameServer;
    }

    public void setGameServer(GameServer gameServer) {
        this.gameServer = gameServer;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
