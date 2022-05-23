class OpeningTimes {
    monday: Time;
    tuesday: Time;
    wednesday: Time;
    thursday: Time;
    friday: Time;
    saturday: Time;
    sunday: Time;

    constructor(
        monday: Time,
        tuesday: Time,
        wednesday: Time,
        thursday: Time,
        friday: Time,
        saturday: Time,
        sunday: Time
    ) {
        this.monday = monday
        this.tuesday = tuesday
        this.wednesday = wednesday
        this.thursday = thursday
        this.friday = friday
        this.saturday = saturday
        this.sunday = sunday
    }

}

type Time = {
    from: string;
    to: string;
} | "closed";

export default OpeningTimes;

export type { Time };