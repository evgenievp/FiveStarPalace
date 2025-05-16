import CSVGenerators.ReadAmenities;
import CSVGenerators.ReadRooms;
import Hotel.FiveStarPalace;
import Hotel.rooms.DeluxeRoom;
import Hotel.rooms.DoubleRoom;
import Hotel.rooms.SingleRoom;
import Hotel.rooms.SuiteRoom;
import Interfaces.GeneralRoom;
import Interfaces.User;
import Users.CasualUser;
import promotionCodeGen.PromotionCodeGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialization

        FiveStarPalace hotel = new FiveStarPalace();
        ReadRooms rooms = new ReadRooms();
        rooms.readRooms();
        ArrayList<GeneralRoom> hotelRooms = rooms.getRooms();
        hotel.setRooms(hotelRooms);
        ReadAmenities stuff = new ReadAmenities(hotel);
        stuff.setRoomAmenities();
        System.out.println(hotel.getRooms());

        //


        boolean entered = false;
        while (true) {
            System.out.println("\n=== Five Star Palace Menu ===");
            if (!entered) {
                System.out.println("1. Регистрация на потребител");
            }
            if (!entered) {
                System.out.println("2. Вход в системата");
            }
            if (entered) {
                System.out.println("3. Изход от системата");
                System.out.println("4. Показване на единични стаи");
                System.out.println("5. Показване на двойни стаи");
                System.out.println("6. Показване на делукс стаи");
                System.out.println("7. Показване на суит стаи");
                System.out.println("10. Резервация на стая");
            }
            if (entered) {
                System.out.println("0. Изход");
            }
            System.out.print("Избери опция: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Потребителско име: ");
                    String username = scanner.nextLine();
                    System.out.print("Парола: ");
                    String password = scanner.nextLine();
                    if (hotel.getUser(username) != null) {
                        System.out.println("Този потребител вече съществува.");
                        break;
                    } else {
                        CasualUser newUser = new CasualUser(username, password);
                        hotel.registerUser(newUser);
                        System.out.println("Регистрацията е успешна!");
                        break;
                    }
                case 2:
                    System.out.print("Потребителско име: ");
                    String loginUser = scanner.nextLine();
                    System.out.print("Парола: ");
                    String loginPass = scanner.nextLine();
                    CasualUser loggedUser = hotel.signIn(new CasualUser(loginUser, loginPass));
                    if (!loggedUser.getUsername().equals(loggedUser)) {
                        System.out.println("Успешен вход. Здравей, " + loginUser);
                        entered = true;
                    } else {
                        System.out.println("Грешен потребител и/или парола.");
                    }
                    break;
                case 3:
                    if (entered) {
                        hotel.signOut();
                        entered = false;
                        System.out.println("Изход от системата.");
                        break;
                    } else {
                        System.out.println("Не сте в системата.");
                        break;
                    }
                case 4:
                    if (entered) {
                        System.out.println("Единични стаи:");
                        for (SingleRoom room : hotel.getSingleRooms()) {
                            System.out.println(room.getRoomNumber() + " | " + room.getStatus());
                        }
                    }
                    break;
                case 5:
                    if (entered) {
                        System.out.println("Двойни стаи:");
                        for (DoubleRoom room : hotel.getDoubleRooms()) {
                            System.out.println(room.getRoomNumber() + " | " + room.getStatus());
                        }
                    }
                    break;
                case 6:
                    if (entered) {
                        System.out.println("Делукс стаи:");
                        for (DeluxeRoom room : hotel.getDeluxeRooms()) {
                            System.out.println(room.getRoomNumber() + " | " + room.getStatus());
                        }
                    }
                    break;
                case 7:
                    if (entered) {
                        System.out.println("Суит стаи:");
                        for (SuiteRoom room : hotel.getSuiteRooms()) {
                            System.out.println(room.getRoomNumber() + " | " + room.getStatus());
                        }
                    }
                    break;
                case 10:
                    if (entered) {
                        System.out.println("Избери тип стая за резервация:");
                        System.out.println("1. Единична");
                        System.out.println("2. Двойна");
                        System.out.println("3. Делукс");
                        System.out.println("4. Суит");
                        System.out.println("5. Отмяна на резервация.");
                        int roomChoice = Integer.parseInt(scanner.nextLine());
                        ArrayList<? extends GeneralRoom> availableRooms = new ArrayList<>();
                        switch (roomChoice) {
                            case 1:
                                availableRooms = hotel.getSingleRooms();
                                break;
                            case 2:
                                availableRooms = hotel.getDoubleRooms();
                                break;
                            case 3:
                                availableRooms = hotel.getDeluxeRooms();
                                break;
                            case 4:
                                availableRooms = hotel.getSuiteRooms();
                                break;
                            case 5:
                                System.out.println("Моля въведете потребителско име и парола: ");
                                String user = scanner.nextLine();
                                System.out.println("Моля въведете паролата си: ");
                                String currentPassword = scanner.nextLine();
                                User userProfile = hotel.getUser(user);
                                if (userProfile.authenticate(user, currentPassword) && userProfile.getRoomReservation() != null)  {
                                    if (userProfile.cancelBook()) {
                                        System.out.println("Успешен отказ");
                                    }
                                    else {
                                        System.out.println("Резервацията не може да бъде отменена.");
                                    }
                                }
                                break;
                            default:
                                System.out.println("Невалиден избор.");
                                break;
                        }
                        if (availableRooms.isEmpty()) {
                            System.out.println("Няма свободни стаи от този тип.");
                            break;
                        }
                        System.out.println("Свободни стаи:");
                        for (GeneralRoom r : availableRooms) {
                            System.out.println("Номер: " + r.getRoomNumber() + " | Цена: " + r.getPrice(null));
                        }
                        System.out.print("Въведи номер на стаята за резервация: ");
                        String roomNumber = scanner.nextLine();
                        GeneralRoom selectedRoom = hotel.getRoom(roomNumber);
                        if (selectedRoom == null || !selectedRoom.getStatus().equals("Free")) {
                            System.out.println("Невалиден избор или стаята не е свободна.");
                            break;
                        }
                        System.out.print("Колко дни ще останете? ");
                        int days = scanner.nextInt();
                        scanner.nextLine();
                        CasualUser currentUser = hotel.getUser(selectedRoom.getRoomNumber());
                        PromotionCodeGenerator gen = new PromotionCodeGenerator(currentUser);
                        gen.genCode();
                        currentUser.setCode(gen.getCode());
                        double totalPrice = selectedRoom.bookRoomForDays(days, currentUser.getDiscountCode());
                        if (totalPrice == 0) {
                            System.out.println("Резервацията не може да бъде направена.");
                        } else {
                            currentUser.book(selectedRoom, days);
                            System.out.println("Успешно резервира стая " + selectedRoom.getRoomNumber() + " за " + days + " дни.");
                        }
                        break;
                    }
                case 0:
                    System.out.println("Излизане от програмата...");
                    return;
                default:
                    System.out.println("Невалидна опция. Опитай отново.");
            }
        }
    }
}







