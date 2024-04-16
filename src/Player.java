// Player 클래스는 게임에서 플레이어의 정보를 관리합니다.
public class Player {
    // 플레이어의 이름을 저장하는 문자열 변수
    private String name;
    // 플레이어의 공격력을 저장하는 정수형 변수
    private int attackPower;
    // 플레이어의 방어력을 저장하는 정수형 변수
    private int defensePower;
    // 플레이어의 생명력을 저장하는 정수형 변수
    private int healthPower;
    private Tribe tribe;


    // Player 클래스의 생성자: 플레이어 생성 시 이름, 공격력, 방어력, 생명력을 초기화합니다.
    public Player(String name, int attackPower, int defensePower, int healthPower, Tribe tribe) {
        this.name = name; // 플레이어의 이름을 설정합니다.
        this.attackPower = attackPower; // 플레이어의 공격력을 설정합니다.
        this.defensePower = defensePower; // 플레이어의 방어력을 설정합니다.
        this.healthPower = healthPower; // 플레이어의 생명력을 설정합니다.
        this.tribe = tribe;
    }

    // 이름을 반환하는 메소드: 플레이어의 이름을 반환합니다.
    public String getName() {
        return name;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public void setTribe(Tribe tribe) {
        this.tribe = tribe;
    }

    // 생명력을 설정하는 메소드: 지정된 값으로 플레이어의 생명력을 업데이트합니다.
    public void setHealthPower(int healthPower) {
        this.healthPower = healthPower;
    }

    // 공격력을 반환하는 메소드: 플레이어의 공격력을 반환합니다.
    public int getAttackPower() {
        return attackPower;
    }

    // 방어력을 반환하는 메소드: 플레이어의 방어력을 반환합니다.
    public int getDefensePower() {
        return defensePower;
    }

    // 생명력을 반환하는 메소드: 플레이어의 현재 생명력을 반환합니다.
    public int getHealthPower() {
        return healthPower;
    }
}
