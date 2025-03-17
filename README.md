Delivery Management System
A comprehensive system for managing package and envelope deliveries with driver assignments.

Overview
The Delivery Management System is a Java-based application designed to help delivery companies track and manage items, drivers, and delivery assignments. The system handles different types of delivery items (packages and envelopes) and allows for the assignment of these items to drivers based on their vehicle capacity and delivery zones.

Features
Item Management

Create and track two types of delivery items: Packages and Envelopes
Each item has a unique serial number, sender/receiver information, and delivery status
Support for item insurance options with appropriate cost calculations
Driver Management

Create and manage delivery drivers with specific:
Active delivery zones (based on postal code ranges)
Vehicle capacity (weight and volume limitations)
Vehicle registration information
Delivery Assignment

Assign items to drivers based on:
Driver's active delivery zone
Vehicle capacity constraints
Item characteristics (weight, volume)
Track delivery status (Received, Assigned, Delivered)
Reporting and Monitoring

Display all items by various criteria (status, type)
Monitor driver loads and available capacity
Calculate total costs for all deliveries
Class Structure
DeliveryItem: Base class for delivery items with common attributes

Package: Extension of DeliveryItem with dimensions, weight, and volume
Envelope: Extension of DeliveryItem with specific size options
Driver: Manages driver information and delivery assignments

Fadi_Louise: Main application class with the console-based menu interface

How to Use
Adding Drivers:

Specify name, vehicle registration, capacity limits, and delivery zone
Receiving Items:

Choose between packages and envelopes
Enter sender/receiver information
For packages: enter dimensions and weight
For envelopes: specify the envelope size
Assigning Deliveries:

Select an item by serial number
Choose a driver for assignment
System automatically checks capacity and zone restrictions
Tracking Deliveries:

View items by status (Received, Assigned, Delivered)
Check driver's current load
Requirements
Java 8 or higher
The system was developed using NetBeans IDE
Future Enhancements
Potential improvements could include:

Graphical user interface
Database integration for persistent storage
Delivery route optimization
Customer notification system
Delivery time tracking and estimation
© 2023 Fadi Louise. All Rights Reserved.
