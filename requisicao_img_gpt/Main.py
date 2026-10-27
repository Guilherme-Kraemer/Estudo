import base64
import os
import requests

API_KEY = os.getenv("OPENAI_API_KEY")

if not API_KEY:
    raise ValueError(
        "Chave da API não encontrada. Defina a variável de ambiente OPENAI_API_KEY antes de executar."
    )

prompt = input("Descreva a imagem que você quer gerar: ")

url = "https://api.openai.com/v1/images/generations"
headers = {
    "Authorization": f"Bearer {API_KEY}",
    "Content-Type": "application/json",
}

payload = {
    "model": "gpt-image-1",
    "prompt": prompt,
    "size": "1024x1024",
    "quality": "high",
    "response_format": "b64_json",
}

response = requests.post(url, headers=headers, json=payload, timeout=120)
response.raise_for_status()

result = response.json()
image_data = result["data"][0].get("b64_json")

if not image_data:
    raise ValueError(f"Resposta inesperada da API: {result}")

file_name = "imagem_gerada.png"
file_path = os.path.join(os.getcwd(), file_name)

with open(file_path, "wb") as image_file:
    image_file.write(base64.b64decode(image_data))

print(f"Imagem salva em: {file_path}")


