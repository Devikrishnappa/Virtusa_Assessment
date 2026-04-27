def calculate_fare(km, vehicle_type, hour):
    rates = {
        "Economy": 10,
        "Premium": 18,
        "SUV": 25
    }
    # check valid vehicle type
    if vehicle_type not in rates:
        print("Service Not Available for this vehicle type!")
        return
    base_fare = km * rates[vehicle_type]
    # surge pricing logic
    if 17 <= hour <= 20:
        base_fare = base_fare * 1.5
    return base_fare

# MAIN PROGRAM

print("CITYCAB FARE CALCULATOR")

try:
    km = float(input("Enter distance (km): "))
    vehicle_type = input("Enter vehicle type (Economy / Premium / SUV): ")
    hour = int(input("Enter hour of travel (0-23): "))
    fare = calculate_fare(km, vehicle_type, hour)
    if fare:
        print("\n----- RIDE RECEIPT -----")
        print("Distance:", km, "km")
        print("Vehicle Type:", vehicle_type)
        print("Hour:", hour)

        if 17 <= hour <= 20:
            print("Surge Applied: YES (1.5x)")

        print("Total Fare: Rs.", fare)

except ValueError:
    print("Invalid input Please enter correct values")
