import net.openhft.chronicle.wire.SelfDescribingMarshallable;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class MarketData extends SelfDescribingMarshallable {

    int securityId;
    long time;
    float last;
    float high;
    float low;

    public MarketData() {
    }

    public MarketData(int securityId, long time, float last, float high, float low) {
        this.securityId = securityId;
        this.time = time;
        this.last = last;
        this.high = high;
        this.low = low;
    }

    /**
     * static Object recycle(MarketData m){
     * String message = "high: " + m.high + " - last: " + m.last + " - low: " + m.low + " - secureid: " + m.securityId + " - time: " + m.time;
     * System.out.println(message.length());
     * return message;
     * }
     **/

    static MarketData recycle(MarketData marketData) {
        final int id = ThreadLocalRandom.current().nextInt(1000);
        marketData.setSecurityId(id);
        final float nextFloat = ThreadLocalRandom.current().nextFloat();
        final float last = 20 + 100 * nextFloat;
        marketData.setLast(last);
        marketData.setHigh(last * 1.1f);
        marketData.setLow(last * 0.9f);
        marketData.setTime(System.currentTimeMillis());
        return marketData;
    }

    static MarketData create() {
        MarketData marketData = new MarketData();
        int id = ThreadLocalRandom.current().nextInt(1000);
        marketData.setSecurityId(id);
        float nextFloat = ThreadLocalRandom.current().nextFloat();
        float last = 20 + 100 * nextFloat;
        marketData.setLast(last);
        marketData.setHigh(last * 1.1f);
        marketData.setLow(last * 0.9f);
        marketData.setTime(System.currentTimeMillis());
        return marketData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarketData that = (MarketData) o;
        return securityId == that.securityId && time == that.time && Float.compare(that.last, last) == 0 && Float.compare(that.high, high) == 0 && Float.compare(that.low, low) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(securityId, time, last, high, low);
    }

    public int getSecurityId() {
        return securityId;
    }

    public void setSecurityId(int securityId) {
        this.securityId = securityId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public float getLast() {
        return last;
    }

    public void setLast(float last) {
        this.last = last;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    @Override
    public String toString() {
        return "MarketData{" +
                "securityId=" + securityId +
                ", time=" + time +
                ", last=" + last +
                ", high=" + high +
                ", low=" + low +
                '}';
    }
}
