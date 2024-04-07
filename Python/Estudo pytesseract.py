import cv2
import pytesseract

pytesseract.pytesseract.tesseract_cmd = "C:/Program Files/Tesseract-OCR/tesseract.exe"
image_location = r'C:\Users\guica\Documents\ARC SYSTEM WORKS\deca_1.png'

image = cv2.imread(image_location)
print(pytesseract.image_to_string(image))